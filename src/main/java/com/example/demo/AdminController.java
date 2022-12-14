package com.example.demo;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
@Autowired
	AdminDAO dao;

Logger log=Logger.getAnonymousLogger();
@ResponseBody
@RequestMapping("/login")
public void login(HttpServletRequest req,HttpServletResponse res,@RequestParam("name") String suser,@RequestParam("pwd") String spassword) throws IOException {
	
	log.info("inside the request mapping of login");
	log.info("object from user"+dao.findbyuser(suser));
	log.info("object from password"+dao.findbypassword(spassword));
	if(dao.findbyuser(suser).equals(dao.findbypassword(spassword))) {
		log.info("validation of the user is successfull");
		HttpSession session = req.getSession();
		session.setAttribute("loggedInUser_userName", suser);
		res.sendRedirect("index.jsp");
		//return "success";
	}
	else {
		log.info("failed");
		res.sendRedirect("error.jsp");
	//return "login failed ! check the credentials or register first";
	}	
}
@ResponseBody
@RequestMapping("/register")
public void register(HttpServletRequest req,HttpServletResponse res) throws IOException
{
	
	log.info("into the register mapping");
	String suser=req.getParameter("name");
	String spassword=req.getParameter("pwd");
	String semail=req.getParameter("email");
	log.info("data set");
	User student =new User();
	student.setName(suser);
	student.setPassword(spassword);
	student.setEmail(semail);
	 log.info("values set");
	 log.info(student.getName()+"   "+student.getPassword()+"   "+student.getEmail());
	 
	 User ss=dao.insert(student);
	 if(ss!=null) {
		 res.sendRedirect("login.jsp");
		
	 }
	 else {
		res.sendRedirect("error.jsp");
		
	 }

}
@RequestMapping("getuser")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	log.info("in get all request");
	ModelAndView mv=new ModelAndView();
	log.info("created mv object");
	List<User> list=dao.getuser();
	log.info("called getall method");
	mv.setViewName("userlist.jsp");
	log.info("went to jsp");
	mv.addObject("list",list);
	log.info("sent a list to the jsp");
	return mv;
}

}

