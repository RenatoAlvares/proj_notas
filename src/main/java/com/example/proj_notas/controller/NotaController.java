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

import com.example.proj_notas.entity.Nota;
import com.example.proj_notas.service.NotaService;


@RestController
@RequestMapping("/api/nota")
public class NotaController {

	@Autowired
	private NotaService notaService;

	@GetMapping("/all")
	public ResponseEntity<List<Nota>> getNotas(){
		try {
			List<Nota> lista = new ArrayList<>();
			lista = notaService.readAll();
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
	public ResponseEntity<Nota> getNotas(@PathVariable("id") int id){
		Nota c = notaService.read(id);
		if(c.getId()>0) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			notaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Nota> save(@RequestBody Nota nota){
		try {
			double nota1=nota.getNota1();
			double nota2=nota.getNota2();
			double nota3=nota.getNota3();
			double nota4=nota.getNota4();
			double promedio=0;
			if((nota1+nota2+nota3+nota4)>0) {
				promedio=(nota1+nota2+nota3+nota4)/4;
			}
			nota.setPromedio(promedio);
			Nota cl = notaService.create(nota);
			return new ResponseEntity<>(cl, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Nota> update(@RequestBody Nota nota, @PathVariable("id") int id){
		try {
			Nota n = notaService.read(id);
			if(n.getId()>0) {
				n.setNombrealum(nota.getNombrealum());
				n.setApepaternoalum(nota.getApepaternoalum());
				n.setApematernoalum(nota.getApematernoalum());				
				n.setNota1(nota.getNota1());
				n.setNota2(nota.getNota2());
				n.setNota3(nota.getNota3());
				n.setNota4(nota.getNota4());
				
				double nota1=nota.getNota1();
				double nota2=nota.getNota2();
				double nota3=nota.getNota3();
				double nota4=nota.getNota4();
				double promedio=0;
				if((nota1+nota2+nota3+nota4)>0) {
					promedio=(nota1+nota2+nota3+nota4)/4;
				}
				n.setPromedio(promedio);
				return new ResponseEntity<>(notaService.create(n),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
