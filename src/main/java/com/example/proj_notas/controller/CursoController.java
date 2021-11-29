package com.example.proj_notas.controller;

import java.util.ArrayList;
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

import com.example.proj_notas.entity.Curso;
import com.example.proj_notas.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/all")
	public ResponseEntity<List<Curso>> getCursos(){
		try {
			List<Curso> lista = new ArrayList<>();
			lista = cursoService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> getCursos(@PathVariable("id") int id){
		Curso c = cursoService.read(id);
		if(c.getId()>0) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			cursoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Curso> save(@RequestBody Curso cu){
		try {
			Curso c = new Curso();
			c.setNombre(cu.getNombre());
			return new ResponseEntity<>(cursoService.create(c), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Curso> update(@RequestBody Curso cu, @PathVariable("id") int id){
		try {
			Curso c = cursoService.read(id);
			if(c.getId()>0) {
				c.setNombre(cu.getNombre());
				return new ResponseEntity<>(cursoService.create(c),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
