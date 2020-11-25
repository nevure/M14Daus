package com.ITAcademy.M14Daus.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITAcademy.M14Daus.entity.TiradesDau;
/**
 * 
 * Interfaz que extiende al repositorio JPA
 * @author Rubén Rodríguez 
 *
 */
@Repository
public interface TiradesDauDAO extends JpaRepository<TiradesDau, Long> {

	public void deleteAllByUsuarioId(Long id);

	public List<TiradesDau> findAllByUsuarioId(Long id);

}
