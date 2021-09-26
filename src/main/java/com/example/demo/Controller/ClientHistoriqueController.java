package com.example.demo.Controller;



import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.IService.IClienthistoriqueService;
import com.example.demo.entities.ClientHistorique;




//@RestController
@Controller
public class ClientHistoriqueController {
@Autowired
IClienthistoriqueService iclientserv;

//@CrossOrigin(origins = "*")

@GetMapping("/Clienthisto")
public String getclienthistorique(Model model){
	List<ClientHistorique> clientshisto = iclientserv.getclienthistorique();
	model.addAttribute("clientshisto",clientshisto);
	return "/Clienthisto.html";
	
}
@PostMapping("addclienthistorique")
public String addclienthistorique(@RequestBody ClientHistorique ch) {
	return iclientserv.addclienthistorique(ch);
}
@PutMapping("updateclienthistorique")
public String updateclienthistorique(@RequestBody ClientHistorique ch) {
	return iclientserv.updateclienthistorique(ch);
}

@GetMapping("deleteclienthistorique/{id}")
public String deleteclienthistorique(@PathVariable("id") int idch) {
	return iclientserv.deleteclienthistorique(idch);
}

@GetMapping("/search")
public String viewHomePage(Model model, @Param("acctstatustype") String acctstatustype) {
	System.out.println(iclientserv.findByAcctstatustype(acctstatustype));
    List<ClientHistorique> listclienthistos = iclientserv.findByAcctstatustype(acctstatustype);
    model.addAttribute("clientshisto", listclienthistos);
    model.addAttribute("acctstatustype", acctstatustype);
    System.out.println(listclienthistos.get(0)); 
    return "Clienthisto";
}
@GetMapping("/rechercheframe")
public String findByFramedipaddress(Model model,@Param("framedipaddress") String framedipaddress ) {
	 List<ClientHistorique> listclienthistos = iclientserv.findByFramedipaddress(framedipaddress);
	    model.addAttribute("clientshisto", listclienthistos);
	    model.addAttribute("framedipaddress",framedipaddress);
	    
	    return "Clienthisto";
	
	}
@GetMapping("findBetween")
public ClientHistorique findBetween(@RequestParam(name = "d1") String d1,@RequestParam(name = "framedipaddress")String framedipaddress){
	System.out.println(d1);
	System.out.println(framedipaddress);
return iclientserv.findBetween(d1, framedipaddress);	
}
@GetMapping("findipBetween/{framedipaddress}")
public ClientHistorique  findipBetween( @PathVariable(name ="framedipaddress") String framedipaddress) {
	System.out.println(framedipaddress);
	return iclientserv.findipBetween(framedipaddress);
}
@GetMapping("finddateBetween/{d1}")
public ClientHistorique  finddateBetween( @PathVariable("d1") String d1) {
	System.out.println(d1);
	Timestamp date=Timestamp.valueOf(d1);
	System.out.println(date);
	System.out.println(iclientserv.finddateBetween(date));
	return iclientserv.finddateBetween(date);
}
//http://localhost:8081/SpringMVC/servlet/getMoyencommandMonth/{a}/{m}/{acctstatustype}
	@GetMapping(value = "/getstartclientMonthMonth/year/{a}/month/{m}/acctstatustype/{acctstatustype}") 
	public List<Object[]> getstartclientMonthMonth(@PathVariable("a") Integer a,@PathVariable("m")  Integer m,@PathVariable("acctstatustype") String acctstatustype) {
		return iclientserv.getMoyenstartclientMonth(a, m, acctstatustype);
	}

	//http://localhost:8081/SpringMVC/servlet/getMoyencommandyear/{b}/{a}
	@GetMapping(value = "/getstartclientyear/id/{b}/year/{a}") 
	public List<Object[]> getstartclientyear(@PathVariable("b") int id,@PathVariable("a") Integer a) {
		return iclientserv.getstartclientyear(id, a);
	}
	@GetMapping(value = "findByAcctstarttime/{acctstarttime}") 
	public List<ClientHistorique> findByAcctstarttime(@PathVariable("acctstarttime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date
			acctstarttime) {
		System.out.println(iclientserv.findByAcctstarttime(acctstarttime));
		return iclientserv.findByAcctstarttime( acctstarttime);
	}
	
	@GetMapping(value = "/findAllWithAcctstarttimeBefore") 
	public String findAllWithAcctstarttimeBefore(Model model,@Param("acctstarttime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date acctstarttime,@Param("acctstoptime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date acctstoptime,@Param("framedipaddress")String framedipaddress) {
		List<ClientHistorique> listclienthistos =iclientserv.findAllWithAcctstarttimeBefore(acctstarttime,acctstoptime,framedipaddress);
		model.addAttribute("clientshisto", listclienthistos);
	    model.addAttribute("acctstarttime",acctstarttime);
	    model.addAttribute("acctstoptime",acctstoptime);
	    model.addAttribute("framedipaddress",framedipaddress);
		return "Clienthisto";
	}
	
}