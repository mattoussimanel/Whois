package com.example.demo.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.IService.IClienthistoriqueService;
import com.example.demo.Repository.ClienthistoriqueRepository;
import com.example.demo.entities.ClientHistorique;


@Service
public class ClientHistoriqueService implements IClienthistoriqueService{
@Autowired
private ClienthistoriqueRepository clientrepos;

@Override
public List<ClientHistorique> getclienthistorique() {
	//System.out.println(clientrepos.findAll());
	return clientrepos.findAll();
}

@Override
public String addclienthistorique(ClientHistorique ch) {
	clientrepos.save(ch);
	return "the client is added succeffuly";
}

@Override
public String updateclienthistorique(ClientHistorique ch) {
	
	clientrepos.save(ch);
	return "the client is updated succeffuly";
}

@Override
public String deleteclienthistorique(int idch) {
	ClientHistorique ch = clientrepos.findById(idch).get();
	clientrepos.delete(ch);
	return "the customer is deleted succefuly";
}

@Override
public List<ClientHistorique> findByAcctstatustype(String acctstatustype) {
	
	return clientrepos.findByAcctstatustype(acctstatustype);
}

@Override
public List<ClientHistorique> findByFramedipaddress(String framedipaddress) {
	
	return clientrepos.findByFramedipaddress(framedipaddress);
}
@Override
public ClientHistorique findBetween(String d1, String framedipaddress){
	return clientrepos.findBetween(d1, framedipaddress);
}

@Override
public ClientHistorique findipBetween(String framedipaddress) {
	
	return clientrepos.findipBetween(framedipaddress);
}

@Override
public ClientHistorique finddateBetween(java.sql.Timestamp d1) {
	
	return clientrepos.finddateBetween(d1);
}

@Override
public List<Object[]> getMoyenstartclientMonth(Integer a, Integer m, String acctstatustype) {
	
	return clientrepos.getstartclientMonth(a, m, acctstatustype);
}

@Override
public List<Object[]> getstartclientyear(int id, Integer a) {
	
	return clientrepos.getstartclientyear(id, a);
}


@Override
public List<ClientHistorique> findByAcctstarttime(Date acctstarttime) {
	
	return clientrepos.findByAcctstarttime( acctstarttime);
}

@Override
public List<ClientHistorique> findAllWithAcctstarttimeBefore(Date acctstarttime ,Date acctstoptime ,String framedipaddress) {
	
	return clientrepos.findAllWithAcctstarttimeBefore(acctstarttime,acctstoptime ,framedipaddress);
}


/*
@Override
public List<ClientHistorique> getAllBetweenDates(Date startDate, Date endDate) {
	return clientrepos.getAllBetweenDates(startDate, endDate);
}
*/
}
