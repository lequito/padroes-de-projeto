package com.alex.gof.repositories;

import org.springframework.data.repository.CrudRepository;

import com.alex.gof.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
