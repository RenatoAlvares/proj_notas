package com.example.proj_notas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proj_notas.entity.Nota;
import com.example.proj_notas.repository.NotaRepository;
import com.example.proj_notas.service.NotaService;

@Service
public class NotaServiceImpl implements NotaService{

	@Autowired
	private NotaRepository notaRepository;
	@Override
	public List<Nota> readAll() {
		// TODO Auto-generated method stub
		return notaRepository.findAll();
	}

	@Override
	public Nota read(int id) {
		// TODO Auto-generated method stub
		return notaRepository.findById(id).get();
	}

	@Override
	public Nota create(Nota notas) {
		// TODO Auto-generated method stub
		return notaRepository.save(notas);
	}

	@Override
	public Nota update(Nota notas) {
		// TODO Auto-generated method stub
		return notaRepository.save(notas);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		notaRepository.deleteById(id);
	}

}
