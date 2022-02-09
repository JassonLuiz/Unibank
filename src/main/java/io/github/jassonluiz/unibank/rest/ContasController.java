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

import io.github.jassonluiz.unibank.model.entity.Contas;
import io.github.jassonluiz.unibank.model.repository.ContasRepository;

@RestController
@RequestMapping("/api/contas")
public class ContasController {

	public final ContasRepository repository;
	
	@Autowired
	public ContasController(ContasRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Contas> obterTodos(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contas salvar(@RequestBody @Valid Contas conta) {
		return repository.save(conta);
	}
	
	@GetMapping("{id}")
	public Contas findById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada!"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		repository.findById(id)
					.map(conta -> {
						repository.delete(conta);
						return Void.TYPE;
					})
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada!"));
	}
}
