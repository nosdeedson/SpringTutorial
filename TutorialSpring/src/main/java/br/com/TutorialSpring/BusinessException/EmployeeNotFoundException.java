package br.com.TutorialSpring.BusinessException;

public class EmployeeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException( Long id) {
		super("Could not find employee id: " + id);
	}
	
	public EmployeeNotFoundException( String erro) {
		super(erro);
	}


}
