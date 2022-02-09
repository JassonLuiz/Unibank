package io.github.jassonluiz.unibank.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class PessoaFisica extends Clientes{

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Integer idPF;
	
	@Column(nullable = false, length = 11)
	@NotNull(message = "Campo CPF obrigátorio.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	private String sexo;
	
}
