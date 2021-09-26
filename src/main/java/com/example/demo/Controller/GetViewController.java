package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Repository.ClientRepository;
import com.example.demo.entities.Client;


@Controller
public class GetViewController {
	
		@Autowired 
		private ClientRepository clienttRepo;
		
		@RequestMapping(value = "/addClient",method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView returnAddClient()
		{
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("addClient");
		  //mv.addObject("var", "halim");
		  return mv;
		  
		}
		
		@RequestMapping(value = "/listClient",method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView returnListClient()
		{
		  ModelAndView mv = new ModelAndView();
		  List<Client> clients = clienttRepo.findAll();
		  mv.setViewName("listClients");
		  mv.addObject("clients", clients);
		  return mv;
		  
		}

	}


