package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Cable;
import com.demo.service.CableService;

@Controller
@RequestMapping("/cables")
public class CableController {
	
	
	@Autowired
	private CableService cservice;
	
	
	@GetMapping("/getCables")
	public ModelAndView getAllCables(HttpSession session)
	{
		List<Cable> clist=cservice.getCables();
		System.out.println(clist.toString());
		return new ModelAndView("displayCable","clist",clist);
	}
	
	
	@GetMapping("/addNewCable")
	public String addNewCable(HttpSession session)
	{
		return "insertCable";
	}
	
	@PostMapping("/newCable")
	public ModelAndView insertCable(@RequestParam int custid,@RequestParam String basepack,@RequestParam String optionpack)
	{
		Cable c = new Cable(custid,basepack,optionpack);
		cservice.addCable(c);
		
		return new ModelAndView("redirect:/cables/getCables");
	}
	
	
	
	@GetMapping("/delete/{custid}")
	public ModelAndView deleteCable(@PathVariable int custid)
	{
		cservice.deleteByCustId(custid);
		
		return new ModelAndView("redirect:/cables/getCables");
	}
	
	@GetMapping("/edit/{custid}")
	public ModelAndView editByCustId(@PathVariable int custid)
	{
		Cable cdata = cservice.getCable(custid);
		return new ModelAndView("editData","c",cdata);
	}
	
	
	@PostMapping("/updateCable")
	public ModelAndView updateCable(@RequestParam int custid,@RequestParam String basepack,@RequestParam String optionpack)
	{
		Cable c = new Cable(custid,basepack,optionpack);
		cservice.updateCable(c);
			
		return new ModelAndView("redirect:/cables/getCables");
	}
	
	@GetMapping("/getDataById/{custid}")
	public ModelAndView getDataByCustId(@PathVariable int custid)
	{
		Cable cdata = cservice.getDataByCustId(custid);
		return new ModelAndView("viewData","c",cdata);
	}
	
	

}
