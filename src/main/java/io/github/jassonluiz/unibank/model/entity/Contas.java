package io.github.jassonluiz.unibank.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConta;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Clientes cliente;
	
	private Integer agencia;
	private Integer numero;
	private BigDecimal saldo;
	
}
