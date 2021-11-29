package com.example.proj_notas.service;

import java.util.List;

import com.example.proj_notas.entity.Curso;

public interface CursoService {

	List<Curso> readAll();
	Curso read(int id);
	Curso create(Curso curso);
	Curso update(Curso curso);
	void delete(int id);
}
