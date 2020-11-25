/**
 * 
 */
package com.ITAcademy.M14Daus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ITAcademy.M14Daus.DAO.TiradesDauDAO;
import com.ITAcademy.M14Daus.entity.TiradesDau;

/**
 * Clase servicio de Tirades dau
 * @author ru
 *
 */
@Service
public class TiradesDauService implements ITiradesDauServices {
	
	//Inyectamos el objeto DAO de tiradas
	@Autowired
	TiradesDauDAO tiradasDao;

	@Override
	public TiradesDau novaTirada(TiradesDau tirada) {
		return tiradasDao.save(tirada);

	}

	@Override
	public List<TiradesDau> listaTiradaByUser(Long id) {
		return tiradasDao.findAllByUsuarioId(id);
	}

		@Override
	@Transactional
	public void eliminarTiradasByUser(Long id) {
		tiradasDao.deleteAllByUsuarioId(id);

	}

	@Override
	public List<TiradesDau> listaTodasTiradas() {
		return tiradasDao.findAll();
	}

	@Override
	public boolean reiniciojuego() {
		// TODO Auto-generated method stub
		return false;
	}

}
