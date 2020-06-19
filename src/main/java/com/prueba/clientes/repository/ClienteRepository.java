package com.prueba.clientes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.clientes.model.Cliente;


@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
	
	@Query("select avg(edad) as promedio from Cliente")
	public float promedio();
	
	@Query("select stddev(edad) as desviacion from Cliente")
	public float desviacion();
 
	
}
