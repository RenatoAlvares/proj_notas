package com.example.proj_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proj_notas.entity.Curso;


@Repository
public interface CursoRepository  extends JpaRepository<Curso, Integer>{

}
