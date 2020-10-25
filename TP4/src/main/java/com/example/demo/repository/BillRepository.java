package com.example.demo.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Bill;

public interface BillRepository  extends JpaRepository<Bill, Integer>{

//	Obtener las compras por dia y usuario, obtiene el id de la compra
	@Query("SELECT COUNT(b.id) as cantidad FROM Client c "
			+ "LEFT JOIN c.bill b "
			+ "LEFT JOIN b.products p "
			+ "WHERE c.idClient = ?1 AND b.date = ?2 "
			+ "GROUP BY c.idClient")
	Integer getBuyDayClient(Integer idClient, Date fecha);
	
}
