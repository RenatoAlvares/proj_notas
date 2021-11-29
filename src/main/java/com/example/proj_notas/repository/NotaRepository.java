package com.example.proj_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proj_notas.entity.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer>{

}
