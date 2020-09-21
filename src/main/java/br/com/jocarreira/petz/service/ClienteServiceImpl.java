package br.com.jocarreira.petz.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import br.com.jocarreira.petz.dto.ClienteDto;
import br.com.jocarreira.petz.modelo.Cliente;

@Service
public class ClienteServiceImpl implements Servico<ClienteDto> {

	private Client client;
	private WebTarget webTarget;
	private final String URL_SERVICE = "http://localhost:8082/clientes";

	
	@Override
	public ClienteDto get(Long id) {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/{id}").path(String.valueOf(id));
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.get();
 
		return response.readEntity(ClienteDto.class);

	}

	@Override
	public List<ClienteDto> getAll() {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/");
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.get();
 
		List<ClienteDto> retorno = response.readEntity(new GenericType<List<ClienteDto>>(){});

		return retorno;
	}

	@Override
	public ClienteDto save(ClienteDto cliente) {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/");
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.post(Entity.entity(cliente, "application/json;charset=UTF-8"));
 
		return response.readEntity(ClienteDto.class);
		
	}

	@Override
	public ClienteDto update(ClienteDto cliente) {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/");
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.put(Entity.entity(cliente, "application/json;charset=UTF-8"));
 
		return response.readEntity(ClienteDto.class);
	}

	@Override
	public Boolean delete(Long id) {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/{id}").path(String.valueOf(id));
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.delete();
		if (response.getStatus() == 200) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	
	}

}
