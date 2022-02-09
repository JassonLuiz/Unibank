package io.github.jassonluiz.unibank.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.jassonluiz.unibank.model.entity.Clientes;
import io.github.jassonluiz.unibank.model.repository.ClientesRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

	public final ClientesRepository repository;
	
	@Autowired
	public ClientesController(ClientesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Clientes> todosClientes(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Clientes salvar(@RequestBody @Valid Clientes cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping("{id}")
	public Clientes findById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		repository.findById(id)
					.map(cliente -> {
						repository.delete(cliente);
						return Void.TYPE;
					})
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}
	
	public void atualizar(@PathVariable Integer id, @RequestBody @Valid Clientes ClienteAtualizado) {
		repository.findById(id)
					.map(cliente -> {
						cliente.setConta(ClienteAtualizado.getConta());
						cliente.setNome(ClienteAtualizado.getNome());
						cliente.setEndereco(ClienteAtualizado.getEndereco());
						return repository.save(cliente);
					})
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}
}




