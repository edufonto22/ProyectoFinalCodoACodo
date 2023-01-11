package ar.com.codoacodo.domain;

import java.util.Date;

public class Producto {
	
	private Long id;
	private String tipo;
	private String titulo;
	private Date fechaAlta;
	private Integer puntuacion;
	private String comentario;
	
	public Producto(String tipo, String titulo, Date fechaAlta, Integer puntuacion, String comentario) {
		super();
		this.tipo = tipo;
		this.titulo = titulo;
		this.fechaAlta = fechaAlta;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}

	public Producto(Long id, String tipo, String titulo, Date fechaAlta, Integer puntuacion, String comentario) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.titulo = titulo;
		this.fechaAlta = fechaAlta;
		this.puntuacion = puntuacion;
		this.comentario = comentario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Integer getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", tipo=" + tipo + ", titulo=" + titulo + ", fechaAlta="
		+ fechaAlta + ", puntuacion=" + puntuacion + ", comentario=" + comentario + "]";
	}
	
}
