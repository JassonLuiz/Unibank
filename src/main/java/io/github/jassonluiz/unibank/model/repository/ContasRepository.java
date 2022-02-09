package io.github.jassonluiz.unibank.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jassonluiz.unibank.model.entity.Contas;

public interface ContasRepository extends JpaRepository<Contas, Integer>{

}
