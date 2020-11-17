package shiva.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valid")
public class ValidUser {
	@RequestMapping(value="/{id}/{name}", method=RequestMethod.GET)
	public String validateUser(@PathVariable int id, @PathVariable String name) {
		if(id == 503 && name.equals("Shiva prasad")) {
			return "Welcome Hemanth";
		}
		return "Invalid User";
	}
}