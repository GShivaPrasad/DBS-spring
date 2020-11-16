package spring.example.springDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
		@RequestMapping("/test1")
		public String Hello()
		{
			System.out.println("In the Hello()");
			return "Hey!! Request Mapping successful";
		}

	}


