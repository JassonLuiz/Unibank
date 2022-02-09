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

import io.github.jassonluiz.unibank.model.entity.PessoaJuridica;
import io.github.jassonluiz.unibank.model.repository.PessoaJuridicaRepository;

@RestController
@RequestMapping("/api/pessoaJuridica")
public class PessoaJuridicaController {

	public final PessoaJuridicaRepository repository;
	
	@Autowired
	public PessoaJuridicaController(PessoaJuridicaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<PessoaJuridica> obterTodos(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaJuridica salvar(@RequestBody @Valid PessoaJuridica pessoaJuridica) {
		return repository.save(pessoaJuridica);
	}
	
	@GetMapping("{id}")
	public PessoaJuridica findById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PJ não encontrado!"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
	   repository.findById(id)
				.map(pessoaJuridica -> {
					repository.delete(pessoaJuridica);
					return Void.TYPE;
				})
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PJ não encontrado!"));
	}
}
