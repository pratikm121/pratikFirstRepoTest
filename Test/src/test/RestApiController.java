package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
	
	//Map to store employees, ideally we should use database
	Map<Integer, DummyData> empData = new HashMap<Integer, DummyData>();
 
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody List<DummyData> getDummyEmployee() {
		System.out.println("Start createDummyEmployee");
		List<DummyData> data = new ArrayList<DummyData>();
		DummyData emp = new DummyData();
		emp.setFname("Pratik");
		emp.setLname("Mehta");
		emp.setAge(32);
		emp.setAddress("Bhawani Residerncy");
		empData.put(1, emp);
		data.add(emp);
		System.out.println(emp.toString());
		
		emp = new DummyData();
		emp.setFname("Manvi");
		emp.setLname("Mehta");
		emp.setAge(30);
		emp.setAddress("Bhawani Residerncy");
		empData.put(2, emp);	
		data.add(emp);
		System.out.println(emp.toString());
		
		
		return data;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String createEmployee(@RequestBody String empData) {
		System.out.println("Start getDummyEmployee = " + empData.toString());
		
		return empData;
	}
}
