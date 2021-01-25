package com.subsidiary.test.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.subsidiary.test.model.Sucursal;
import com.subsidiary.test.model.SucursalKpi;
import com.subsidiary.test.repository.SucursalRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
public class SucursalControllerTest {
	
	
	@Autowired
	private SucursalRepository service;

	@MockBean
	private SucursalRepository repository;
	 
	
//	@Test
//	public void saveUserTest() {
//		Sucursal suc = new Sucursal(100, "testSucursal", 12.656, -12.656);
//		when(repository.save(suc)).thenReturn(suc);
//		assertEquals(suc, service.save(suc));
//
//	}
//
//	@Test
//	public void getUsersTest() {
//		when(repository.findAll()).thenReturn(Stream.of(new Sucursal(376, "testSucursal_1", 127.656, -125.656),
//				new Sucursal(376, "testSucursal_2", 212.656, -132.656)).collect(Collectors.toList()));
//		assertEquals(2, service.findAll());
//	}
//
//	@Test
//	public void getSubsidiaryclosestDistancetest() {
//		SucursalKpi sucursalKpi = new SucursalKpi();
//		sucursalKpi.setDistancia(127.656);
//		sucursalKpi.setInformacionSucursal("Test_sucursalIngo");
//		assertEquals(1, sucursalKpi);
//	}

}
