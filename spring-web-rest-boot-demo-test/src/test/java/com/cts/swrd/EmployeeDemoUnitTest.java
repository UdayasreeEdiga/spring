package com.cts.swrd;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.swrd.dao.EmployeeRepository;
import com.cts.swrd.model.Department;
import com.cts.swrd.model.Employee;

@RunWith(SpringRunner.class)//bridge between spring boot test featues and Juint
@DataJpaTest //configuring h2,an in-memory database,setting hibernate,spring data and 
public class EmployeeDemoUnitTest {
	private Employee emps[];
	@Autowired 
	TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDemoUnitTest() {
		emps=new Employee[] {
				new Employee("uday","Ediga",45000,LocalDate.now(),Department.DEVELOPMENT,"7730020098","uday@gmail.com")
				};
				
		}
		
		@Before
		public void beforeEachTest() {
			for(Employee e:emps) {
				entityManager.persist(e);
			}
			entityManager.flush();
		}
		
		@After
		public void afterEachTest() {
			for(Employee e :emps) {
				entityManager.flush();
			}
		}
		@Test
		public void whenFindByMobileNumber_thenReturnEmployee() {
			Employee e=employeeRepository.findByMobileNumber(emps[0].getMobileNumber());
			assertThat(e).isEqualTo(emps[0]);
		}
		@Test
		public void whenFindByMobileNumber_withNonExistingMobileNumber_thenReturnNull() {
			Employee e=employeeRepository.findByMobileNumber("7730022097");
			assertThat(e).isNull();
		}

}
