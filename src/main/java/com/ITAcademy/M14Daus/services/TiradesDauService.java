/**
 * 
 */
package com.ITAcademy.M14Daus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.M14Daus.DAO.TiradesDauDAO;
import com.ITAcademy.M14Daus.entity.TiradesDau;

/**
 * @author ru
 *
 */
@Service
public class TiradesDauService implements ITiradesDauServices {
	
	@Autowired
	TiradesDauDAO tiradasDao;

	@Override
	public TiradesDau novaTirada(TiradesDau tirada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TiradesDau> listaTiradaByUser(Long id) {
		return tiradasDao.findAllByUsuarioId(id);
	}

	@Override
	public int cuantasTiradasByUser(Long id) {
		return 0;
	}

	@Override
	public int cuantasVictoriasByUser(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void eliminarTiradasByUser(Long id) {
		tiradasDao.deleteByUsuarioId(id);
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
