package shiva.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import shiva.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	List<User> lt = new ArrayList<User>();
	UserController(){
		lt.add(new User("Shivaprasad",21));
		lt.add(new User("Akhil",20));
		lt.add(new User("Hemu",22));
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ResponseEntity<String> validateData(@RequestBody String name){
		boolean b = false;
		for(User t : lt) {
			if(t.getName().equals(name)) {
				b=true;
				break;
			}
		}
		System.out.println(b ? "Valid User" : "Invalid User");
		return new ResponseEntity(HttpStatus.CREATED);
	}

}
