package com.uniovi.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.User;
import com.uniovi.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;// Para gestion de usuarios

	@Autowired
	private RolesService rolesService;// para obtener los roles

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;// para cifrar las contraseñas

	@PostConstruct
	public void init() {
	}

	/*
	 * Devuelve todos los usuarios menos el usuario en sesion
	 */
	public Page<User> getUsers(User user, Pageable pageable) {
		Page<User> users = usersRepository.findAllUsersExceptLoggedInUser(user, pageable);
		return users;
	}

	/*
	 * Devuelve un usuario encontrado por id (unica)
	 */
	public User getUser(Long id) {
		return usersRepository.findOne(id);
	}

	/*
	 * Añade un usuario nuevo al sistema, cifrando la password, le asiga el rol por
	 * defecto
	 */
	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		if (user.getRole() == null)
			user.setRole(rolesService.getRoleByType("ROLE_REGISTERED"));

		usersRepository.save(user);// guardamos el resultado en la BBDD
	}

	/* Elimina un usuario segun su id (unico) */
	public void deleteUser(Long id) {
		usersRepository.delete(id);
	}

	/* Devuelve un USUARIO entero encontrandolo mediante el email (unico) */
	public User getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}

	/*
	 * Devuelve todos los USUARIOS que cuadren cone el texto de busqueda en nombre o
	 * email
	 */
	public Page<User> searchUserByNameAndEmail(String searchText, Pageable pageable) {
		return usersRepository.searchByNameAndEmail("%" + searchText + "%", pageable);
	}

	/*
	 * Devuelve todos los usuarios que NO son amigos y NO nos enviaron peticion de
	 * amistad
	 */
	public List<User> searchNotFriendsNorRequestedUsers(User user) {
		return usersRepository.searchNotFriendsNorRequestedUsers(user);
	}

	/* Devuelve todos los usuarios */
	public Page<User> getAllUsers(Pageable pageable) {
		return usersRepository.findAll(pageable);
	}

}
