package com.example.proj_notas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proj_notas.entity.Curso;
import com.example.proj_notas.repository.CursoRepository;
import com.example.proj_notas.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository cursoRepository;
	@Override
	public List<Curso> readAll() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Curso read(int id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id).get();
	}

	@Override
	public Curso create(Curso cursos) {
		// TODO Auto-generated method stub
		return cursoRepository.save(cursos);
	}

	@Override
	public Curso update(Curso cursos) {
		// TODO Auto-generated method stub
		return cursoRepository.save(cursos);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(id);
	}
}
