/**
 * 
 */
package com.ITAcademy.M14Daus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ITAcademy.M14Daus.entity.TiradesDau;

/**
 * @author ru
 *
 */
@Service
public class TiradesDauService implements ITiradesDauServices {

	@Override
	public TiradesDau novaTirada(TiradesDau tirada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TiradesDau> listaTiradaByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cuantasTiradasByUser(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cuantasVictoriasByUser(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean eliminarTiradasByUser(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TiradesDau> listaTodasTiradas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean reiniciojuego() {
		// TODO Auto-generated method stub
		return false;
	}

}
