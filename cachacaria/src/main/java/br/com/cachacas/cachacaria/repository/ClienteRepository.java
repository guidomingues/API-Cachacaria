package br.com.cachacas.cachacaria.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.cachacas.cachacaria.entity.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{
	
	public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
}
