package com.epam.producing.testProject;

import com.epam.producing.testProject.config.SwaggerConfig;
import com.epam.producing.testProject.model.Address;
import com.epam.producing.testProject.model.Employee;
import com.epam.producing.testProject.repository.AddressRepository;
import com.epam.producing.testProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestProjectApplication {

    @Autowired
	private AddressRepository addressRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) 	{
		SpringApplication.run(TestProjectApplication.class, args);
		//SpringApplication.run(SwaggerConfig.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		// Cleanup the tables
		addressRepository.deleteAllInBatch();
		employeeRepository.deleteAllInBatch();

		// =======================================

		// Create a Post
		Employee employee = new Employee("Alla", "Senior");

		// Create two tags
		Address address1 = new Address("Kyev", "Grushevskogo", "20", "10");
		Address address2 = new Address("Kyev", "Bogenko", "20", "10");


		// Add tag references in the post
		employee.getAddresses().add(address1);
		employee.getAddresses().add(address2);

		// Add post reference in the tags
		address1.getEmployees().add(employee);
		address2.getEmployees().add(employee);

		employeeRepository.save(employee);

		// =======================================

	}

}
