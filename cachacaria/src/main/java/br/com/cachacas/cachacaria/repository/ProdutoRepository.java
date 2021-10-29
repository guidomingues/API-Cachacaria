package br.com.cachacas.cachacaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cachacas.cachacaria.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
	
	public List<Produto> findAllByCodigoDeBarraContainingIgnoreCase(String codigoDeBarra);

}
