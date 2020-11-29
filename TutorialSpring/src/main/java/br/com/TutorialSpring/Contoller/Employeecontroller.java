package br.com.TutorialSpring.Contoller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.TutorialSpring.BusinessException.EmployeeNotFoundException;
import br.com.TutorialSpring.Model.Employee;
import br.com.TutorialSpring.Repository.EmployeeRepository;

@RestController
public class Employeecontroller {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	List<Employee> all(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return this.employeeRepository.save(newEmployee);
	}
	
	@GetMapping("/employees/{id}")
	EntityModel<Employee> one(@PathVariable Long id) {
 		Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
 		Link link = Link.of("/employees/{id}");
 		Link link1 = Link.of("/employees");
 		  return EntityModel.of(employee, link, link1);
	}
	
	@PutMapping("employees/{id}")
	Employee replaceEmployee( @RequestBody Employee newEmployee, @PathVariable Long id ) {
		return employeeRepository.findById(id).map(
				e -> {
					e.setName(Optional.ofNullable(newEmployee.getName()).orElseThrow(() -> new EmployeeNotFoundException("Name not informed.") ));
					e.setRole(Optional.ofNullable(newEmployee.getRole()).orElseThrow( () -> new EmployeeNotFoundException("Role not informed.") ));
					return this.employeeRepository.save(e);
				}
		).orElseGet(() -> {
			newEmployee.setId(id);
			return this.employeeRepository.save(newEmployee);
		});
	}
	
	@DeleteMapping("employees/{id}")
	Employee deleteEmployee(@PathVariable Long id) {
		Employee e = this.employeeRepository.findById(id).orElseThrow( ()-> new EmployeeNotFoundException(id));
		this.employeeRepository.deleteById(id);
		return e;
	}
	
	
	
	
	
	
	
	
}
