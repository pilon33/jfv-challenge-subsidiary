package com.subsidiary.test.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.subsidiary.test.exception.ResouceNotFoundException;
import com.subsidiary.test.model.Sucursal;
import com.subsidiary.test.model.SucursalKpi;
import com.subsidiary.test.repository.SucursalRepository;
import  com.subsidiary.test.util.*;

@RestController
@RequestMapping("/api")
public class SucursalController {
	
	private final Logger logger = LoggerFactory.getLogger(SucursalController.class);

	
	@Autowired
	private SucursalRepository sucursalRepository;

	@PostMapping("/sucursales")
	public Sucursal addSubsidiary(@RequestBody Sucursal sucursal) {
	    logger.info("Create Subsidiary");
		return sucursalRepository.save(sucursal);
	}

	@GetMapping("/sucursales")
	public ResponseEntity<List<Sucursal>> getAllSubsidiary() {
	    logger.info("Find All subsidiary : {}-{}" );
		return ResponseEntity.ok(sucursalRepository.findAll());
	}

	@GetMapping("sucursales/{id}")
	public ResponseEntity<Sucursal> findSubsidiaryById(@PathVariable(value = "id") Integer sucursalId) {
	    logger.info("Find subsiadiary by id: {}-{}", sucursalId );
		Sucursal sucursal = sucursalRepository.findById(sucursalId)
				.orElseThrow(() -> new ResouceNotFoundException("Subsidiary not found" + sucursalId));
		return ResponseEntity.ok().body(sucursal);
	}
	
	
	
	@GetMapping("/sucursalCercana/{latitud}/{longuitud}")
	public SucursalKpi getSubsidiaryclosestDistance(@PathVariable("latitud") double latitud, @PathVariable("longuitud") double longuitud) {
	    logger.info("Find Subsidiary by closest Distance : {} in -{}", latitud, longuitud);
		List<Sucursal> listaSucursales = sucursalRepository.findAll();
		SucursalKpi sucursalKpi = new SucursalKpi();
		sucursalKpi = CalculadorDistancia.calcularDistancia(latitud, longuitud, listaSucursales);
		return sucursalKpi;
	}


}
