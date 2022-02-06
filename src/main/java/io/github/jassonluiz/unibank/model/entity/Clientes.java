package io.github.jassonluiz.unibank.model.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {

	private String nome;
	private String cpf;
	
}
