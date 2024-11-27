package com.cupcake_store.store.controllers;

import com.cupcake_store.store.entities.Cupcake;
import com.cupcake_store.store.services.CupcakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cupcakes")
public class CupcakeController {

	@Autowired
	private CupcakeService cupcakeService;

	@GetMapping
	public ResponseEntity<List<Cupcake>> getAllCupcakes(){
		return new ResponseEntity<>(cupcakeService.findAllCupcakes(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cupcake> getCupcakesById(@PathVariable Long id){
		return new ResponseEntity<>(cupcakeService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cupcake> saveCupcake(@RequestBody Cupcake cupcake){
		return new ResponseEntity<>(cupcakeService.save(cupcake), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCupcakeById(@PathVariable Long id){
		cupcakeService.delete(id);
		return ResponseEntity.ok("Cupcake deletado com sucesso");
	}
}
