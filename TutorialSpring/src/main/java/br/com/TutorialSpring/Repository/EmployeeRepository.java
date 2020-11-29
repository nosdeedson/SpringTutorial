package br.com.TutorialSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.TutorialSpring.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
