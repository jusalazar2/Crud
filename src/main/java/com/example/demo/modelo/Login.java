package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String usuario;
	private String correo;
	private String contraseña;
	private int rool;
	
	public Login() {
		
	}

	public Login(int id, String usuario, String correo, String contraseña, int rool) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.correo = correo;
		this.contraseña = contraseña;
		this.rool = rool;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getRool() {
		return rool;
	}

	public void setRool(int rool) {
		this.rool = rool;
	}

	

	

}
