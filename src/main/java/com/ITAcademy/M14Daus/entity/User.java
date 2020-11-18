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
	
	private double percentExit;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dataRegistre")
	private Calendar dataRegistre;

	@OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<TiradesDau> tiradesDau = new ArrayList<TiradesDau>();


	public User() {
		super();
	}

	public User(@NotBlank String nomUsuari, double percentExit, List<TiradesDau> tiradesDau) {
		super();
		this.nomUsuari = nomUsuari;
		this.percentExit = percentExit;
		this.tiradesDau = tiradesDau;
	}

	public String getNomUsuari() {
		return nomUsuari;
	}

	public void setNomUsuari(String nomUsuari) {
		this.nomUsuari = nomUsuari;
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

	@Override
	public String toString() {
		return "User [nomUsuari=" + nomUsuari + ", percentExit=" + percentExit + ", dataRegistre=" + dataRegistre
				+ ", tiradesDau=" + tiradesDau + "]";
	}

	
	
	
	

}
