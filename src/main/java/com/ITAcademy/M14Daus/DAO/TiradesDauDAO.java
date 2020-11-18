package com.ITAcademy.M14Daus.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.M14Daus.entity.TiradesDau;
/**
 * 
 * Interfaz que extiende al repositorio JPA
 * @author Rubén Rodríguez 
 *
 */

public interface TiradesDauDAO extends JpaRepository<TiradesDau, Long> {

}