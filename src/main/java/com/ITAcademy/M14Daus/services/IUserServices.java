package com.ITAcademy.M14Daus.services;

import java.util.List;

import com.ITAcademy.M14Daus.entity.User;


public interface IUserServices {
	
	public User creaUsuario(User user);
	public User selectUserById(Long id);
	public Boolean eliminaUserById(Long id);
	public User updateUser(User user);
	public boolean existeUser(String nomUser);
	public List<User>	listUsers();
	
}
