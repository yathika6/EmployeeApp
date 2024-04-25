package com.jsp.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.DAO.EmployeeDao;
import com.jsp.DTO.Employee;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	
	@RequestMapping("/insert")
	public ModelAndView getEmployee()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("create.jsp");
		return mv;
	}
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		dao.saveEmployee(employee);
		ModelAndView v= new ModelAndView();
		v.setViewName("index.jsp");
		return v;
	}
	@RequestMapping("/search")
	public ModelAndView searchEmployee() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("get.jsp");
		return mv;
	}
	
	@RequestMapping("/display")
	public ModelAndView searchById(@ModelAttribute Employee employee) {
		ModelAndView mv= new ModelAndView();
		Employee emp=dao.getEmployeeById(employee.getId());
		mv.addObject("employee", emp);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("delete.jsp");
		return mv;
	}
	
	@RequestMapping("/deleteId")
	public ModelAndView deleteById(@ModelAttribute Employee employee) {
		ModelAndView mv= new ModelAndView();
		dao.deleteEmploye(employee.getId());
		mv.setViewName("index.jsp");
		return mv;
	}
	@RequestMapping("/update")
	public ModelAndView update() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("update.jsp");
		return mv;
	}
	@RequestMapping("/updateEmployee")
	public ModelAndView updateSalary(@ModelAttribute Employee employee) {
		ModelAndView mv= new ModelAndView();
		dao.updateEmployee(employee);
		mv.setViewName("display.jsp");
		return mv;
		
	}
	
	@RequestMapping("/allDetails")
	public ModelAndView getAllEmployee() {
		ModelAndView mv= new ModelAndView();
		List<Employee> employees= dao.getAllEmployee();
		mv.addObject("employeelist", employees);
		mv.setViewName("displayAll.jsp");
		return mv;
	}
}
