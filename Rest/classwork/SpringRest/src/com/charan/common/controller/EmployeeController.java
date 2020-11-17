package com.charan.common.controller;
import com.charan.common.model.Employee;
import com.google.gson.Gson;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll")

public class EmployeeController {
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getMovie(@PathVariable int id)
	{
		HashMap<Integer, Employee> hm1 = new HashMap<Integer, Employee>();
		hm1.put(1, new Employee(1, "Shiva Prasad", 60000, 3500, 4000, 300));
		hm1.put(2, new Employee(2, "Tharun", 45000, 3500, 4000, 200));
		hm1.put(3, new Employee(3, "Hemanth", 75000, 5500, 4000, 200));
		hm1.put(4, new Employee(4, "vinod", 60000, 4500, 4000, 350));
		
		Employee emp=null;
		if(hm1.containsKey(id))
		{
			emp=hm1.get(id);
		}
		
		emp.setGross_sal(emp.getBasic() + emp.getHra() + emp.getAllowance());
		emp.setFinal_deductions((int) (emp.getDeductions() + (emp.getGross_sal()*0.2)));
		emp.setTotal_sal(emp.getGross_sal()-emp.getFinal_deductions());
		
		return emp.toString();
	}
	
	@RequestMapping(value="/display", method=RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name)
	{
		System.out.println(name);
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
