package com.subsidiary.test.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.subsidiary.test.model.Sucursal;
import com.subsidiary.test.model.SucursalKpi;

public class CalculadorDistancia {
	
	public static SucursalKpi calcularDistancia(double lat1, double lon1, List<Sucursal> list) {
		Map<Integer, Double> distanceAll = new HashMap();
		SucursalKpi sucursalKpi = new SucursalKpi();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + "--" + list.get(i).getDescripcion().toString() + "--" + list.get(i).getLatitude()
					+ "--" + list.get(i).getLongitude());
			distanceAll.put(i, distancia(lat1, lon1, list.get(i).getLatitude(), list.get(i).getLongitude(), "K"));
		}
	
		Map<Integer, Double> sortedByCount = distanceAll.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		for (Map.Entry<Integer, Double> entry : sortedByCount.entrySet()) {
			sucursalKpi
					.setInformacionSucursal("La sucursal mas cercana en Kilometros es :" + list.get(entry.getKey()).getDescripcion());
			sucursalKpi.setDistancia(sortedByCount.get(entry.getKey()));
			break;
		}

		return sucursalKpi;

	}
	
	
	private static double distancia(double lat1, double lon1, double lat2, double lon2, String unit) {
		
	
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}
	
}
