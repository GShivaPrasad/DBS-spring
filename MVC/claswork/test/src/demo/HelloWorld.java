package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HelloWorld {
	
	@RequestMapping("/hello")
	public String helloWorld(Model m) {
	
		String msg = "Hemanth Kv";
		m.addAttribute("message",msg);
		return "hellopage";
	
	}
}
//import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class HelloWorld {
//	@RequestMapping("/hello")
//	public String helloWorld(Model m) {
//		String message = "This is my first MVC project...";
//		m.addAttribute("message", message);
//		return "hellopage";
//	}
//}
