package io.github.jassonluiz.unibank.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enderecos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;
	
	@Column(nullable = false, length = 150)
	@NotEmpty(message = "Campo rua obrigatorio!")
	private String rua;
	private long numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	@NotEmpty(message = "Campo CEP obrigatorio!")
	private String cep;
	
	private String telefone;
}
