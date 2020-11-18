/**
 * 
 */
package com.ITAcademy.M14Daus.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ITAcademy.M14Daus.entity.User;

/**
 * Interfaz que extiende el repositorio JPA
 * @author Rubén Rodríguez
 */
public interface UserDao extends JpaRepository<User, Long> {
	
	public Boolean existsByNomUsuari(String nomUsuari);
	public User minByPercentExit();
	public Double sumByPercentExit(); // no la utilizamos, pero la dejamos por motivos didácticos.
	
	//Podríamos hacerlo como con minBy y que fuera Hibernate quien la generara, pero por motivos didácticos la creamos nosotros. SEría
	//interesante conocer las diferencias en cuanto a eficiencia. 
	@Query("SELECT max(u.percentExit) FROM User u")
	public User maximoAcierto();
}
