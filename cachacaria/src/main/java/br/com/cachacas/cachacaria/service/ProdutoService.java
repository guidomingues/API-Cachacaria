package br.com.cachacas.cachacaria.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cachacas.cachacaria.DTO.ProdutoDTO;
import br.com.cachacas.cachacaria.entity.Produto;
import br.com.cachacas.cachacaria.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	
	@Autowired
	private ProdutoRepository repository; 
	
	@Autowired
	private ModelMapper modelMapper; 
	
	private ProdutoDTO convertToDTO(Produto produto) {
		return modelMapper.map(produto, ProdutoDTO.class); 
	}
	
	private ProdutoDTO convertToListDTO(List<Produto> codigoDeBarra) {
		return modelMapper.map(codigoDeBarra, ProdutoDTO.class); 
	}

	public Page<ProdutoDTO> findAll(Pageable pageable) {
		Page<Produto> produtos = repository.findAll(pageable);
		return produtos.map(item -> modelMapper.map(item, ProdutoDTO.class));
	}

	public ProdutoDTO findById(long id) {
		Produto produto = repository.findById(id).get();
		return convertToDTO(produto);
	}

	public ProdutoDTO findByCodigoDeBarra(String codigoDeBarra) {
		List<Produto> codigoDeBarra2 = repository.findAllByCodigoDeBarraContainingIgnoreCase(codigoDeBarra);
		return convertToListDTO(codigoDeBarra2);
	}
	public ProdutoDTO saveProduto (Produto produto) {
		repository.save(produto);
		return convertToDTO(produto);
	}
	public void deleteById(long id) {
		repository.deleteById(id);
		
	}

}
