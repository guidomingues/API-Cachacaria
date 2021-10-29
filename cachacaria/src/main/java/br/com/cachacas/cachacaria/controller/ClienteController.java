package br.com.cachacas.cachacaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.cachacas.cachacaria.entity.Cliente;
import br.com.cachacas.cachacaria.repository.ClienteRepository;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> GetById(@PathVariable long id){ 
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> post(@RequestBody Cliente cliente){ 
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente)); 
	}
	
	@PutMapping
	public ResponseEntity<Cliente> put(@RequestBody Cliente cliente){ 
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cliente)); 
	}
	
	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id); 
	}
	
}
