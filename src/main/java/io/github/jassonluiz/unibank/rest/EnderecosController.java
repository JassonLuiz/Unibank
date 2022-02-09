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

import io.github.jassonluiz.unibank.model.entity.Enderecos;
import io.github.jassonluiz.unibank.model.repository.EnderecosRepository;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecosController {

	public final EnderecosRepository repository;
	
	@Autowired
	public EnderecosController(EnderecosRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Enderecos> obterTodos(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Enderecos salvar(@RequestBody @Valid Enderecos endereco) {
		return repository.save(endereco);
	}
	
	@GetMapping("{id}")
	public Enderecos findById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado!"));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) {
		repository.findById(id)
						.map(endereco -> {
							repository.delete(endereco);
							return Void.TYPE;
						})
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado!"));
	}
	
	public void atualizar(@PathVariable Integer id, @RequestBody @Valid Enderecos enderecoAtualizado) {
		repository.findById(id)
						.map(endereco -> {
							endereco.setRua(enderecoAtualizado.getRua());
							endereco.setNumero(enderecoAtualizado.getNumero());
							endereco.setComplemento(enderecoAtualizado.getComplemento());
							endereco.setBairro(enderecoAtualizado.getBairro());
							endereco.setCidade(enderecoAtualizado.getCidade());
							endereco.setUf(enderecoAtualizado.getUf());
							endereco.setCep(enderecoAtualizado.getCep());
							endereco.setTelefone(enderecoAtualizado.getTelefone());
							
							return repository.save(endereco);
						})
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado!"));
	}
}
