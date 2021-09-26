package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.IService.IClientService;
import com.example.demo.entities.Client;



@Controller
public class ClientController {
@Autowired
IClientService clientserv;

@GetMapping("/accueil")
public String showaccueil() {
	return "/Accueil.html";
}
@GetMapping("/listClients.html")
public String showExampleView(Model model)
{
	List<Client> clients = clientserv.getAllclient();
	model.addAttribute("clients",clients);
	return "/listClients.html";
}
@GetMapping("/")
public String showAddClient()
{
	
	return "/addClient.html";
}

@PostMapping("/addC")
public String saveClient(@RequestParam("file") MultipartFile file,
		@RequestParam("cnom") String nom,
		@RequestParam("adresse")String adresse,
		@RequestParam("telephone") String telephone
		,@RequestParam("attribute") String attribute
		,@RequestParam("iproute") String iproute,
		@RequestParam("login") String login,
		@RequestParam("observation") String observation,
		@RequestParam("op") String op,
		@RequestParam("cin") String cin
		)
{
	clientserv.saveclienttodb(file,nom,adresse,telephone,attribute,iproute,login,observation,op,cin);
	return "redirect:/listClients.html";
}
@GetMapping("/deleteClient/{id}")
public String deleteClient(@PathVariable("id") int id)
{
	
	clientserv.deleteClientById(id);
	return "redirect:/listClients.html";
}

@PostMapping("/changeName")
public String changeClientname(@RequestParam("id") int id,
		@RequestParam("newCname") String name)
{
	clientserv.chageClientName(id, name);
	return "redirect:/listClients.html";
}
@PostMapping("/changeAdresse")
public String changeAdresse(@RequestParam("id") int id ,
		@RequestParam("newAdresse") String adresse)
{
	clientserv.changeClientAdresse(id, adresse);
	return "redirect:/listClients.html";
}

@PostMapping("/changeTelephone")
public String changeTelephone(@RequestParam("id") int id ,
		@RequestParam("newTelephone") String telephone)
{
	clientserv.changeClientTel(id, telephone);
	return "redirect:/listClients.html";
}
@PostMapping("/changeAttribute")
public String changeClientAttribute(@RequestParam("id") int id ,
		@RequestParam("newAttribute") String attribute)
{
	clientserv.changeClientAttribute(id, attribute);
	return "redirect:/listClients.html";
}
@PostMapping("/changeLogin")
public String changeLogin(@RequestParam("id") int id ,
		@RequestParam("newLogin") String login)
{
	clientserv.changeClientLogin(id, login);
	return "redirect:/listClients.html";
}
@PostMapping("/changeIproute")
public String changeIproute(@RequestParam("id") int id ,
		@RequestParam("newIproute") String iproute)
{
	clientserv.changeClientIproute(id, iproute);
	return "redirect:/listClients.html";
}
@PostMapping("/changeObservation")
public String changeObservation(@RequestParam("id") int id ,
		@RequestParam("newObservation") String observation)
{
	clientserv.changeClientObservation(id, observation);
	return "redirect:/listClients.html";
}
@PostMapping("/changeOp")
public String changeOp(@RequestParam("id") int id ,
		@RequestParam("newOp") String op)
{
	clientserv.changeClientOp(id, op);
	return "redirect:/listClients.html";
}
@PostMapping("/changeCin")
public String changeCin(@RequestParam("id") int id ,
		@RequestParam("newCin") String cin)
{
	clientserv.changeClientCin(id, cin);
	return "redirect:/listClients.html";
}
}
