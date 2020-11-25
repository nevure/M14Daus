package com.ITAcademy.M14Daus.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;



/**
 * Clase User. Mapeado a la tabla user de la base de datos mysql.
 * Tiene un id único y autoincrementable. Un nombre de usuario y un porcentaje de éxito.
 * con una relación uno a muchos a la tabla de tiradesDau ya que un usuario puede realizar cuantas tiradas
 * desee.
 * @author Rubén Rodríguez
 *
 */
@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nomUsuari;
	
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dataRegistre")
	private Calendar dataRegistre;
	
	private int numLanzamientos=0;
	private int numVictories=0;

	//@Formula("num_victories / num_lanzamientos * 100")
	private double percentExit=0.0;
	
	public int getNumLanzamientos() {
		return numLanzamientos;
	}

	public void setNumLanzamientos(int numLanzamientos) {
		this.numLanzamientos = numLanzamientos;
	}

	@OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<TiradesDau> tiradesDau = new ArrayList<TiradesDau>();

	//Constructores
	public User() {
		this.nomUsuari="ANONIMO";
	}

	public User(Long id, @NotBlank String nomUsuari, double percentExit, List<TiradesDau> tiradesDau) {
		this.id = id;
		if (nomUsuari.equalsIgnoreCase("ANONIMO"))
			this.nomUsuari="ANONIMO";
		else
			this.nomUsuari = nomUsuari;
		this.percentExit = percentExit;
		this.tiradesDau = tiradesDau;
	}
		
	/**
	 * Método que verifica si el nombre de usuario es Anónimo
	 * @return
	 */
	public boolean esAnonimo() {
		 return (this.nomUsuari.equalsIgnoreCase("ANONIMO"));
	}

	
	
	/**
	 * Método que calculo el porcentaje de éxito en función del número de víctorias y el número d elanzamientos.
	 */
	public void calculoExito() {
	
		this.percentExit = (double)getNumVictories()/getNumLanzamientos() * 100;
		
	}		
	
	//SETERRS Y GETTERS
	
	/**
	 * Si el nombre de usuario es anónimo se guarda en la base de datgos como ANONIMO (mayúsculas)
	 * @param nomUsuari
	 */
	public void setNomUsuari(String nomUsuari) {
		if (nomUsuari.equalsIgnoreCase("ANONIMO"))
			this.nomUsuari="ANONIMO";
		else
			this.nomUsuari = nomUsuari;
	}
	
	
	public int getNumVictories() {
		return numVictories;
	}

	public void setNumVictories(int numVictories) {
		this.numVictories = numVictories;
	}
	
	public String getNomUsuari() {
		return nomUsuari;
	}

	public double getPercentExit() {
		return percentExit;
	}

	public void setPercentExit(double percentExit) {
		this.percentExit = percentExit;
	}
	public List<TiradesDau> getTiradesDau() {
		return tiradesDau;
	}

	public void setTiradesDau(List<TiradesDau> tiradesDau) {
		this.tiradesDau = tiradesDau;
	}


	public Calendar getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(Calendar dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	public Long getId() {
		return this.id;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", nomUsuari=" + nomUsuari + ", percentExit=" + percentExit + ", dataRegistre="
				+ dataRegistre + ", numLanzamientos=" + numLanzamientos + ", tiradesDau=" + tiradesDau + "]";
	}



}
