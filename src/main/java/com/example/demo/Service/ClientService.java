package com.example.demo.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.IService.IClientService;
import com.example.demo.Repository.ClientRepository;
import com.example.demo.entities.Client;

import org.springframework.util.StringUtils;



@Service
public class ClientService implements IClientService {
	@Autowired
	private ClientRepository clientrep;

	@Override
	public void saveclienttodb(MultipartFile file,String nom,String adress,String tel,String attribute,String iproute, String login ,String observation,String op
			,String cin) {
		Client c = new Client();

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			c.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		c.setAdresse(adress);
		c.setNom(nom);
		c.setTelephone(tel);
		c.setAttribute(attribute);
		c.setIproute(iproute);
		c.setLogin(login);
		c.setObservation(observation);
		c.setOp(op);
		c.setCin(cin);
		clientrep.save(c);
	}
	@Override
	public List<Client> getAllclient()
	{
		return clientrep.findAll();
	}
	@Override
	public void deleteClientById(int id)
	{
		clientrep.deleteById(id);
	}
	@Override
	public void chageClientName(int id ,String name)
	{
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setNom(name);
		clientrep.save(c);    
	}
	@Override
	public void changeClientAdresse(int id , String adresse)
	{
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setAdresse(adresse);
		clientrep.save(c);
	}
	@Override
	public void changeClientTel(int id,String telephone)
	{
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setTelephone(telephone);
		clientrep.save(c);
	}
	@Override
	public void changeClientAttribute(int id, String attribute) {
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setAttribute(attribute);
		clientrep.save(c);
		
	}
	@Override
	public void changeClientIproute(int id, String iproute) {
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setIproute(iproute);
		clientrep.save(c);
		
	}
	@Override
	public void changeClientLogin(int id, String login) {
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setLogin(login);
		clientrep.save(c);
		
	}
	@Override
	public void changeClientObservation(int id, String observation) {
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setObservation(observation);
		clientrep.save(c);
		
	}
	@Override
	public void changeClientOp(int id, String op) {
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setOp(op);
		clientrep.save(c);	
	}
	@Override
	public void changeClientCin(int id, String cin) {
		Client c = new Client();
		c = clientrep.findById(id).get();
		c.setCin(cin);
		clientrep.save(c);	
		
	}	
}


