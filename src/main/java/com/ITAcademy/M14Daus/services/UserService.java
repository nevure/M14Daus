package com.ITAcademy.M14Daus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.M14Daus.DAO.UserDao;
import com.ITAcademy.M14Daus.entity.User;
@Service
public class UserService implements IUserServices {

	Double total=0.0;

	@Autowired
	UserDao userDao;
	@Override
	public User creaUsuario(User user) {

		return userDao.save(user);
	}

	@Override
	public User selectUserById(Long id) {
		
		return userDao.findById(id).get();
	}

	@Override
	public void eliminaUserById(Long id) {

		userDao.deleteById(id);;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean existeUser(String nomUsuari) {

		return userDao.existsByNomUsuari(nomUsuari);
	}

	@Override
	public List<User> listUsers() {

		return userDao.findAll();
	}



	@Override
	public Boolean userAnonimo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long totalJugadores() {
		return userDao.count();
	}

	@Override
	public Double sumaPorcentajesExito() {
		return userDao.findAll().stream().mapToDouble(user -> user.getPercentExit())
				.sum();
	}

	@Override
	public User jugadorMenorExito() {
		return userDao.minByPercentExit();
	}

	@Override
	public User jugadorMayorExito() {
		return userDao.maximoAcierto();
	}

	@Override
	public Boolean existeUserById(Long id) {
		return userDao.existsById(id);
	}
	
	

}
