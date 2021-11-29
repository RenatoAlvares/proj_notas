package com.example.proj_notas.service;

import java.util.List;

import com.example.proj_notas.entity.Nota;

public interface NotaService {

	List<Nota> readAll();
	Nota read(int id);
	Nota create(Nota nota);
	Nota update(Nota nota);
	void delete(int id);
}
