package alex.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session")
public class LogOutController {
	
   @RequestMapping("logOut")
   public void logOut(HttpServletRequest request, HttpServletResponse response){
	   
	   if(request.getSession(false)!= null&&request.getSession().getAttribute("user")!=null){
	   
		   request.getSession().invalidate();
		   System.out.println("En logout sesion creada");
		   
		try {
			response.sendRedirect("./index.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   }else{
		   
		   request.getSession().invalidate();
		   
		   try {
			response.sendRedirect("./index.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
   }

}
