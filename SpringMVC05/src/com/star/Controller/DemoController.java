package com.star.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
   
	@RequestMapping("demo4")
	public String Demo(Model model)
	{
		
		model.addAttribute("model","我爱你啊");
		
		return "index.jsp";
	}
}
