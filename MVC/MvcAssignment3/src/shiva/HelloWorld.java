package shiva;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HelloWorld {
	
	@RequestMapping("/hello")
	public String helloWorld(Model m) {
	
		String msg = "Shiva Prasad Gangapuram";
		m.addAttribute("message",msg);
		return "hellopage";
	
	}
}