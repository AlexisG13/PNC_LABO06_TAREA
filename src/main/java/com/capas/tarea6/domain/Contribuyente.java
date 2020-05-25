package com.capas.tarea6.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {

	@Id
	@Column(name = "c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_contribuyente;

	@Column(name = "s_nombre")
	@NotEmpty(message = "El campo no puede estar vacio")
	@Size(message = "El nombre no debe tener mas de 30 de caracteres", max = 30)
	private String s_nombre;

	@Column(name = "s_apellido")
	@NotEmpty(message = "El campo no puede estar vacio")
	@Size(message = "El apellido no debe tener mas de 30 de caracteres", max = 30)
	private String s_apellido;

	@Column(name = "s_nit")
	@NotEmpty(message = "El campo no puede estar vacio")
	@Size(message = "El NIT debe tener exactamente 14 caracteres", max = 14, min = 14)
	private String s_nit;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_fecha_ingreso")
	private Date f_fecha_ingreso;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;

	public Contribuyente() {
		super();
	}

	public Integer getC_contribuyente() {
		return c_contribuyente;
	}

	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public String getS_nit() {
		return s_nit;
	}

	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}

	public Date getF_fecha_ingreso() {
		return f_fecha_ingreso;
	}

	public void setF_fecha_ingreso(Date f_fecha_ingreso) {
		this.f_fecha_ingreso = f_fecha_ingreso;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

}
