package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ClientHistorique;





@Repository
public interface ClienthistoriqueRepository extends JpaRepository<ClientHistorique, Integer>{
public List<ClientHistorique>findByAcctstatustype(String acctstatustype);
public List<ClientHistorique>findByFramedipaddress(String framedipaddress);
public List<ClientHistorique>findByAcctstarttime(Date acctstarttime);
@Query("select ch from ClientHistorique ch where ((d1 BETWEEN ch.acctstarttime and ch.acctstoptime) and (ch.framedipaddress) like ip)"	)
public ClientHistorique  findBetween(@Param("d1")String d1, @Param("ip")String framedipaddress);
@Query("select ch from ClientHistorique ch where ch.framedipaddress =:ip"	)
public ClientHistorique  findipBetween( @Param("ip") String framedipaddress);
@Query("select ch from ClientHistorique ch where '2019-07-19 20:39:32' BETWEEN ch.acctstarttime and ch.acctstoptime"	)
public ClientHistorique  finddateBetween( @Param("d1") java.sql.Timestamp d1);
//afficher les produits qui sont passé dans un cmd en affichant la date de cmd de chaque  etat et la moyenne de  total final pour chaque mois 
		@Query("select ch.nom,ch.telephone,ch.cin, DAY(ch.acctstarttime) from ClientHistorique ch where YEAR(ch.acctstarttime)=:a and MONTH(ch.acctstarttime)=:m and ch.acctstatustype=:status group by DAY(ch.acctstarttime) order by ch.id,DAY(ch.acctstarttime) asc")
		public List<Object[]> getstartclientMonth(@Param("a")Integer a, @Param("m")Integer m,  @Param("status")String acctstatustype);
		//afficher les moyenn de commande passés et la date de creation par année
		@Query("select MONTH(ch.acctstarttime) from ClientHistorique ch where ch.id=:p and YEAR(ch.acctstarttime)=:a group by MONTH(ch.acctstarttime)")
		public List<Object[]> getstartclientyear(@Param("p") int id, @Param("a")Integer a);
		 @Query("select a from ClientHistorique a where (a.acctstarttime <= :acctstarttime or a.acctstoptime <= :acctstoptime) and (a.framedipaddress <= :ip)")
		   public  List<ClientHistorique> findAllWithAcctstarttimeBefore(@Param("acctstarttime") Date acctstarttime ,@Param("acctstoptime") Date acctstoptime , @Param("ip")String framedipaddress);
}
