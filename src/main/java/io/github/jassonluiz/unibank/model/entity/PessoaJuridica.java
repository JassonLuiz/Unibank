package io.github.jassonluiz.unibank.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

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
public class PessoaJuridica extends Clientes{
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Integer idPJ;
	
	@Column(nullable = false, length = 14)
	@NotNull(message = "Campo CNPJ obrigátorio.")
	@CNPJ(message = "CNPJ inválido.")
	private String cnpj;
	
	private String razaoSocial;
}
