package com.example.proj_notas.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="curso")
public class Curso implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 3394616932972775021L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso")	
     private int id;
     private String nombre;
     
 	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "curso", fetch = FetchType.LAZY)
 	@JsonIgnore
     private List<Nota> notas = new ArrayList<>();

}
