package com.example.demo.IService;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Client;



public interface IClientService {
	public void  saveclienttodb(MultipartFile file,String nom,String adress,String tel,String attribute , String iproute ,String login,String observation,String op,String cin);
	public List<Client> getAllclient();
	public void deleteClientById(int id);
	public void chageClientName(int id ,String name);
	public void changeClientAdresse(int id , String adresse);
	public void changeClientTel(int id,String telephone);
	public void changeClientAttribute(int id,String attribute);
	public void changeClientIproute(int id,String iproute);
	public void changeClientLogin(int id,String login);
	public void changeClientObservation(int id,String observation);
	public void changeClientOp(int id,String op);
	public void changeClientCin(int id,String cin);
}
