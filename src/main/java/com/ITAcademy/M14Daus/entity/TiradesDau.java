/**
 * 
 */
package com.ITAcademy.M14Daus.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ITAcademy.M14Daus.utilidades.UtilidadesJuego;



/**
 * Entidad que mapea la BD TiradesDau
 * @author Rubén Rodríguez
 *
 */
@Entity
public class TiradesDau {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int dau1;
	
	@Column(name="dau2")
	private int dau2;
	private boolean resultat;
	
	@JoinColumn(name="id_user")
	@ManyToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private User usuario;

	/*
	 * Constructores. la llamada a un constructor hace que se ejecute el método aJugar() que es el responsable de lanzar los dados.
	 */
	public TiradesDau() {
		this.aJugar();
	}

	
	public TiradesDau(User usuario) {
		this.usuario = usuario;
		this.aJugar();

	}


	public TiradesDau(int dau1, int dau2, boolean resultat, User usuario) {
		this.dau1 = dau1;
		this.dau2 = dau2;
		this.resultat = resultat;
		this.usuario = usuario;
	}

	/**
	 * Utilizando la clase utilidades lanzamos dos dados y guardamos el resultado.
	 */
	public void aJugar() {
		this.dau1 = UtilidadesJuego.generaAleatorioDesdeUno(6);
		this.dau2 = UtilidadesJuego.generaAleatorioDesdeUno(6);
		this.resultat = (this.dau1+this.dau2 == 7);
		
	}
	
	//SETTERS Y GETTERS
	public int getDau1() {
		return dau1;
	}			


	public void setDau1(int dau1) {
		this.dau1 = dau1;
	}

	public int getDau2() {
		return dau2;
	}

	public void setDau2(int dau2) {
		this.dau2 = dau2;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public String getUsuario() {
		return usuario.getNomUsuari();
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "TiradesDau [id=" + id + ", dau1=" + dau1 + ", dau2=" + dau2 + ", resultat=" + resultat + ", usuario="
				+ usuario + "]";
	}
	
	
}
