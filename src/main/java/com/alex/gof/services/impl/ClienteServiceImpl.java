package com.alex.gof.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.gof.model.Cliente;
import com.alex.gof.model.Endereco;
import com.alex.gof.repositories.ClienteRepository;
import com.alex.gof.repositories.EnderecoRepository;
import com.alex.gof.services.ClienteService;
import com.alex.gof.services.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		saveClientCep(cliente); 
	}

	
	@Override
	public void atualizar(Long id, Cliente cliente) {
		Optional<Cliente> clienteBd = repository.findById(id);
		if(clienteBd.isPresent()) {
			saveClientCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		repository.deleteById(id);
	}

	private void saveClientCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		repository.save(cliente);
	}

}
