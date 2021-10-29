package br.com.cachacas.cachacaria.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.cachacas.cachacaria.entity.Revendedor;

@Repository
public interface RevendedorRepository extends PagingAndSortingRepository<Revendedor, Long>{
	
	public List<Revendedor> findAllByNomeContainingIgnoreCase(String nome); 

}
