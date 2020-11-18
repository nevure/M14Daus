/**
 * 
 */
package com.ITAcademy.M14Daus.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.M14Daus.entity.User;

/**
 * Interfaz que extiende el repositorio JPA
 * @author Rubén Rodríguez
 */
public interface UserDao extends JpaRepository<User, Long> {

}
