package shiva;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Valid {
	
	@RequestMapping("/valid")
	public String helloWorld(HttpServletRequest req, HttpServletResponse res, Model m) {

		String un = req.getParameter("nm");
		String pw = req.getParameter("pw");
		if(un.equalsIgnoreCase("Admin") && pw.equals("admin")){
			m.addAttribute("id", "503");
			m.addAttribute("name", "shiva");
			m.addAttribute("dept", "CSE");
			m.addAttribute("desig", "Java Dev");
			return "valid";
		}else {
			return "error_valid";
		}
	}
}