package com.subsidiary.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.subsidiary.test.model.Sucursal;



@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Integer> {
	
	
}

	

