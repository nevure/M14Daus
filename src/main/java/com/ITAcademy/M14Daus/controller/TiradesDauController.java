/**
 * 
 */
package com.ITAcademy.M14Daus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.M14Daus.entity.TiradesDau;
import com.ITAcademy.M14Daus.services.TiradesDauService;
import com.ITAcademy.M14Daus.services.UserService;

/**
 * @author ru
 *
 */
@RestController
public class TiradesDauController {
	
	@Autowired
	TiradesDauService dausService;
	
	@Autowired
	UserService usuarioService;
	
	@PostMapping("/players/{id}/games")
	public ResponseEntity<Object> lanzamientoDados(@PathVariable("id") Long id) {
		TiradesDau tirada;
		if (usuarioService.existeUserById(id)) {
			tirada = new TiradesDau(usuarioService.selectUserById(id));
			return ResponseEntity.ok().body(dausService.novaTirada(tirada));
		}
		else
			return ResponseEntity.ok().body("El usuario con id "+id+" No existe");		
	
	}
	@RequestMapping(value="/players/{id}/games", method = RequestMethod.DELETE)
	public String eliminaTiradasUser(@PathVariable("id") Long id) {
		
		return "Tiradas Eliminadas";
	}
	
	@GetMapping("/players/{id}/games")
	public List<TiradesDau> listadoTiradas(@PathVariable("id")Long id){
		return dausService.listaTiradaByUser(id);
	
	}
	
	

	
}
