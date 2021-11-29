package com.example.proj_notas.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="nota")
public class Nota implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = -4609906135186857633L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idnota")
	private int id;
	private String nombrealum;
	private String apepaternoalum;
	private String apematernoalum;
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private double promedio;	

	
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "curso_id", referencedColumnName = "idcurso")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Curso curso;

}
