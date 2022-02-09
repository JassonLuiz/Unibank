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

import io.github.jassonluiz.unibank.model.entity.PessoaFisica;
import io.github.jassonluiz.unibank.model.repository.PessoaFisicaRepository;

@RestController
@RequestMapping("/api/pessoaFisica")
public class PessoaFisicaController {

	public final PessoaFisicaRepository repository;
	
	@Autowired
	public PessoaFisicaController(PessoaFisicaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<PessoaFisica> obterTodos(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaFisica salvar(@RequestBody @Valid PessoaFisica pessoaFisica) {
		return repository.save(pessoaFisica);
	}
	
	@GetMapping("{id}")
	public PessoaFisica findById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PF não encontrado!"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
	   repository.findById(id)
				.map(pessoaFisica -> {
					repository.delete(pessoaFisica);
					return Void.TYPE;
				})
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "PF não encontrado!"));
	}
}
