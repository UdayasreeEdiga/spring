package com.cts.swrd;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.swrd.controller.EmployeeAPI;
import com.cts.swrd.model.Department;
import com.cts.swrd.model.Employee;
import com.cts.swrd.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeAPI.class)
public class EmployeeAPIUnitTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService service;

	@Test
	public void whenFindAll_thenReturnJsonArray() throws Exception {
		Employee emp = new Employee("us", "e", 45000, LocalDate.now(), Department.DEVELOPMENT, "7730022098",
				"us.e@gmail.com");

		List<Employee> allEmployees = Arrays.asList(emp);

		given(service.findAll()).willReturn(allEmployees);

		mvc.perform(get("/emps").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].mobileNumber", is(emp.getMobileNumber())));
	}

}
