package com.example.demo.IService;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ClientHistorique;





public interface IClienthistoriqueService {
public List<ClientHistorique> getclienthistorique();
public String addclienthistorique(ClientHistorique ch);
public String updateclienthistorique(ClientHistorique ch);
public String deleteclienthistorique(int idch);
public List<ClientHistorique>findByAcctstatustype(String acctstatustype);
public List<ClientHistorique>findByFramedipaddress(String framedipaddress);
public ClientHistorique  findipBetween(String framedipaddress);
public ClientHistorique findBetween(String d1, String framedipaddress);
public ClientHistorique  finddateBetween( java.sql.Timestamp d1);
public List<Object[]> getMoyenstartclientMonth(Integer a,Integer m ,String acctstatustype);
public List<Object[]> getstartclientyear(int id,Integer a);
public List<ClientHistorique>findByAcctstarttime(Date acctstarttime);
public List<ClientHistorique> findAllWithAcctstarttimeBefore(Date acctstarttime ,Date acctstoptime ,String framedipaddress);
//public List<ClientHistorique> getAllBetweenDates(Date startDate,Date endDate);

}
