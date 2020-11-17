package shiva;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Emp {
	

	@RequestMapping("/emp/{id1}")
	public String helloWorld(@RequestParam ("name") String name,
							 @RequestParam ("basic") int basic,
							 @RequestParam ("hra") int hra,
							 @RequestParam ("it") int it,
							 @RequestParam ("deductions") int deductions,
							 @PathVariable("id1") int id, 
							 HttpServletRequest req,
							 HttpServletResponse res,
							 Model m) {
		String user = req.getParameter("uname");
		int net, gross_sal;
		if(id==503 && user.equalsIgnoreCase("shiva")) {
			gross_sal = basic+hra+it+deductions;
			net = gross_sal-deductions-it-((basic*12)/100);
			m.addAttribute("gross salary:",gross_sal);
			m.addAttribute("net", net);
			return "emp";
		}else {
			return "emp_err";
		}
	
	}
}