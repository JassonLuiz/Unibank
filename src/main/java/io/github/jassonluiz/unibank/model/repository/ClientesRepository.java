package io.github.jassonluiz.unibank.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jassonluiz.unibank.model.entity.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Integer>{

}
