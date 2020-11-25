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
import com.ITAcademy.M14Daus.entity.User;
import com.ITAcademy.M14Daus.services.TiradesDauService;
import com.ITAcademy.M14Daus.services.UserService;

/**
 * Controlador de las tiradas de dados
 * @author Rubén Rodríguez Fernández
 *
 */
@RestController
public class TiradesDauController {
	
	//Inyectamos los dos servicios
	@Autowired
	TiradesDauService dausService;
	
	@Autowired
	UserService usuarioService;
	
	/**
	 * Lanzamos un dado.
	 * 
	 * @param id  Identificador del jugador
	 * @return resultado de la tirada
	 */
	@PostMapping("/players/{id}/games")
	public ResponseEntity<Object> lanzamientoDados(@PathVariable("id") Long id) {
		TiradesDau tirada;
		//Verificamos que le usuario exista
		if (usuarioService.existeUserById(id)) {
			//Buscamos usuario y lo agregamos a la tirada y creamos la tirada (lo que provoca que relize la tirada de dados)
			User usuario = usuarioService.selectUserById(id);
			tirada = new TiradesDau(usuario);
			
			if (tirada.isResultat())   			//si la tirada es certera incrementamos el número de victorias del usuario.
				usuario.setNumVictories(usuario.getNumVictories()+1);
			
			usuario.setNumLanzamientos(usuario.getNumLanzamientos()+1);		//Incrementamos el número de lanzamientos realizado por el jugador.
			usuario.calculoExito(); 			//Actualizamos el porcentaje de éxito del jugado
			usuarioService.creaUsuario(usuario);  //actualizamos estos datos en la base de datos.
			return ResponseEntity.ok().body(dausService.novaTirada(tirada)); 	//dentro del return guardamos la tirada en la BD

			
		}
		else
			return ResponseEntity.ok().body("El usuario con id "+id+" No existe");		
	
	}
	
	/**
	 * Eliminamos las tiradas del jugador con identificado id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/players/{id}/games", method = RequestMethod.DELETE)
	public String eliminaTiradasUser(@PathVariable("id") Long id) {
		User usuario = usuarioService.selectUserById(id);
		
		//Actualizamos los datos del usuario respecto a las tiradas, poniéndolo todo a 0
		usuario.setNumLanzamientos(0);
		usuario.setNumVictories(0);
		usuario.setPercentExit(0);
		
		usuarioService.creaUsuario(usuario); //actualizamos con los datos a 0 de tiradas.
		
		dausService.eliminarTiradasByUser(id); //eliminamos todas las tiradas del usuario.
;		return "Tiradas Eliminadas";
	}
	//Lista de tiradas por usuario.

	@GetMapping("/players/{id}/games")
	public List<TiradesDau> listadoTiradas(@PathVariable("id")Long id){
		return dausService.listaTiradaByUser(id);
	
	}
	
	
	

	
}
