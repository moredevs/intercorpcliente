package com.prueba.clientes.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.clientes.model.Cliente;
import com.prueba.clientes.repository.ClienteRepository;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clientrepo;
	
	public Cliente createClient(Cliente cliente) throws Exception {
		  Calendar cal = Calendar.getInstance();
 		int randomNum = ThreadLocalRandom.current().nextInt(71, 78 + 1);
 		Date nac = cliente.getFec_nac();
		  cal.setTime(nac);
		  cal.add(Calendar.YEAR,  randomNum  ); 
		  Date muerte = cal.getTime();
		  String muernew = new SimpleDateFormat("yyyy-MM-dd").format(muerte);
		  cliente.setFec_muerte(muernew);
		return clientrepo.save(cliente);
	}
	
	  public Map<String, Object> kpiCliente(){
	      Map<String, Object> map = new HashMap<String, Object>();
	      float promedio= clientrepo.promedio();
	      float desviacion=  clientrepo.desviacion();	  
	      map.put("promedio", promedio);
	      map.put("desviacion", desviacion);
	      return map;      
	   }
	  
	  public List<Cliente> listClient() throws Exception {
		 return  clientrepo.findAll();
		
		}
}
