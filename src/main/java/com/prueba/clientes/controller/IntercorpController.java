package com.prueba.clientes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.clientes.model.Cliente;
import com.prueba.clientes.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@Api(tags = { "IntercorpController" }, produces = "application/json", value = "")
public class IntercorpController {

	@Autowired
	private ClienteService service;
	
	 @GetMapping("")
	 public String  init() {
	   return "intercorp service";
	 }
	 
	 @ApiOperation(value = "Create cliente", consumes = "application/json", produces = "application/json",   response = Cliente.class, responseContainer = "List")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Proceso correcto"),
				@ApiResponse(code = 400, message = "error request"),
				@ApiResponse(code = 500, message = "Problemas internos")
		})
	 @RequestMapping(value = "/creacliente", method = RequestMethod.POST)
	    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) throws Exception {
			HttpStatus status = null;
			 Cliente userCreated = null ;
			try {
		   userCreated = service.createClient(cliente);
		     status = HttpStatus.CREATED;
			} catch (Exception e) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
	        return new ResponseEntity(userCreated, status);
   }
	 
	 @ApiOperation(value = "KPI cliente", consumes = "application/json", produces = "application/json", protocols = "http", response = Object.class, responseContainer = "List")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Proceso correcto"),
				@ApiResponse(code = 400, message = "error request"),
				@ApiResponse(code = 500, message = "Problemas internos")
		})
	 @GetMapping("/kpideclientes")
	 public Map<String, Object>  kpiCliente() {
	      Map<String, Object> map = new HashMap<String, Object>();
		 try {
			 map= service.kpiCliente();
		 } catch (Exception e) {
			 map.put("Error", e.getMessage());
		 }
	   return map;
	 }
	 
	 @ApiOperation(value = "List cliente", consumes = "application/json", produces = "application/json", protocols = "http", response = Cliente.class, responseContainer = "List")
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "Proceso correcto"),
				@ApiResponse(code = 400, message = "error request"),
				@ApiResponse(code = 500, message = "Problemas internos")
		})
	 @GetMapping("/listclientes")
	 public List<Cliente>  listClient() {
		 List<Cliente> clientes = null;
		 try {
			 clientes= service.listClient();
		 } catch (Exception e) {
			  
		 }
	   return clientes;
	 }
}
