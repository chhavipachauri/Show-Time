package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
@Autowired
	MovieDAO dao;
Logger log=Logger.getAnonymousLogger();
@RequestMapping("insert")
public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
	int gid=Integer.parseInt(req.getParameter("id"));
	String gname=req.getParameter("name");
	String gprice=req.getParameter("date");
	String gsize=req.getParameter("price");
	ModelAndView mv=new ModelAndView();
	Movie s=new Movie();
	s.setId(gid);
	s.setName(gname);
	s.setDate(gprice);
	s.setPrice(gsize);
	Movie sd=dao.insert(s);
	if(sd!=null) {
		mv.setViewName("admin.jsp");
	}
	
	return mv;
}

@RequestMapping("delete")
public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
	int id=Integer.parseInt(req.getParameter("id"));	
	ModelAndView mv=new ModelAndView();
	Movie s=new Movie();
	s.setId(id);
	String sd=dao.deleteByid(id);
	if(sd!=null) {
		mv.setViewName("admin.jsp");
	}
	return mv;
}

@RequestMapping("getall")
public ModelAndView getstudents(HttpServletRequest req,HttpServletResponse res) {
	ModelAndView mv=new ModelAndView();
	List<Movie> list=dao.getall();
	mv.setViewName("list.jsp");
	mv.addObject("list",list);
	return mv;
}
@RequestMapping("getallu")
public ModelAndView getustudents(HttpServletRequest req,HttpServletResponse res) {
	ModelAndView mv=new ModelAndView();
	List<Movie> list=dao.getall();
	mv.setViewName("ulist.jsp");
	mv.addObject("list",list);
	return mv;
}

@RequestMapping("/addtocart")
public ModelAndView adtoCart(HttpServletRequest req,HttpServletResponse res, 
		@RequestParam("id") String id)    
{
	ModelAndView mv = new ModelAndView();
	int cartId = Integer.valueOf(id);
	Movie MediCine = dao.findbyid(cartId);
	HttpSession session = req.getSession();
	session.setAttribute("MediCine", MediCine);
	mv.addObject(MediCine);
	mv.setViewName("cart.jsp");
	
	
	return mv;
}


	
}
