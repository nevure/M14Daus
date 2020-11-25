/**
 * 
 */
package com.ITAcademy.M14Daus.utilidades;

/**
 * 
 * Clase utilizades.
 * 
 * Solo tiene un método estático que crea un número aleatorio entre 0 y un máximo pasado como parámetro
 * @author Rubén Rodríguez
 *
 */
public class UtilidadesJuego {
	
	public static int generaAleatorioDesdeUno(int maximo) {

		return (int) Math.floor(Math.random()*maximo+1);
	}
}
