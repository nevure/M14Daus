/**
 * 
 */
package com.ITAcademy.M14Daus.entity;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 * @author ru
 *
 */
@Entity
public class TiradesDau {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int dau1;
	private int dau2;
	private boolean resultat;
	
	@JoinColumn(name="id_user")
	@ManyToOne(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private User usuario;

	public TiradesDau() {
	}

	public TiradesDau(int dau1, int dau2, boolean resultat, User usuario) {
		super();
		this.dau1 = dau1;
		this.dau2 = dau2;
		this.resultat = resultat;
		this.usuario = usuario;
	}

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

	public User getUsuario() {
		return usuario;
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
