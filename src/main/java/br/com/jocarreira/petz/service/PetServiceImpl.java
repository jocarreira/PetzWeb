package br.com.jocarreira.petz.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import br.com.jocarreira.petz.dto.PetDto;
import br.com.jocarreira.petz.modelo.Pet;

@Service
public class PetServiceImpl implements Servico<PetDto> {

	private Client client;
	private WebTarget webTarget;
	private final String URL_SERVICE = "http://localhost:8082/pets";
	
	
	@Override
	public PetDto get(Long id) {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/{id}").path(String.valueOf(id));
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.get();
 
		return response.readEntity(PetDto.class);

	}

	@Override
	public List<PetDto> getAll() {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/");
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.get();
 
		List<PetDto> retorno = response.readEntity(new GenericType<List<PetDto>>(){});
		
		return retorno;
	}

	@Override
	public PetDto save(PetDto pet) {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/");
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.post(Entity.entity(pet, "application/json;charset=UTF-8"));
 
		return response.readEntity(PetDto.class);
		
	}

	@Override
	public PetDto update(PetDto pet) {
		
		this.client = ClientBuilder.newClient(); 
		
		this.webTarget = this.client.target(URL_SERVICE).path("/");
		 
		Invocation.Builder invocationBuilder =  this.webTarget.request("application/json;charset=UTF-8");
 
		Response response = invocationBuilder.put(Entity.entity(pet, "application/json;charset=UTF-8"));
 
		return response.readEntity(PetDto.class);
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
