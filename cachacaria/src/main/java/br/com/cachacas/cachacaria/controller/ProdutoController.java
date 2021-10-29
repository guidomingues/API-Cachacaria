package br.com.cachacas.cachacaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cachacas.cachacaria.DTO.ProdutoDTO;
import br.com.cachacas.cachacaria.entity.Produto;
import br.com.cachacas.cachacaria.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service; 
	@GetMapping
	public Page<ProdutoDTO> getAll(Pageable pageable){
		return service.findAll(pageable); 
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> GetById(@PathVariable long id){ 
		return ResponseEntity.ok(service.findById(id));
	}
	@GetMapping("/codigoDeBarra/{codigoDeBarra}")
	public ResponseEntity<ProdutoDTO> GetByCodigoDeBarra(@PathVariable String codigoDeBarra){
		return ResponseEntity.ok(service.findByCodigoDeBarra(codigoDeBarra)); 
	}
	@PostMapping
	public ResponseEntity<ProdutoDTO> post (@RequestBody Produto produto){ 
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduto(produto));
	}
	@PutMapping
	public ResponseEntity<ProdutoDTO> put (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(service.saveProduto(produto));
	}
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		service.deleteById(id);
	}
	
}
