package application;

import java.util.List;

import domain.AbsStaffMember;
import domain.Employee;
import domain.Volunteer;
import persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		repository = new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
	}
	
	public void createVolunteer(String name, String address, String phone) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone);
		repository.addMember(volunteer);		
	}


	public void payAllEmployeers() {
		for (AbsStaffMember member : repository.getAllMembers()) {
			member.pay();
		}
	
	}

	public void getAllEmployees() {
		for (AbsStaffMember member : repository.getAllMembers()) {
			System.out.println(member);
		}
	}

	
	
	
	
}
