package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Publication;
import com.uniovi.entities.Role;
import com.uniovi.entities.User;

@Service
public class InsertSampleDataService {
	@Autowired
	private UsersService usersService;

	@Autowired
	private RolesService roleService;

	@Autowired
	private FriendRequestService friendRequestService;

	@Autowired
	private FriendshipService friendshipService;

	@Autowired
	private PublicationsService publicationService;

	@PostConstruct
	public void init() {
		// Guardar Roles
		Role role1 = new Role("ROLE_REGISTERED");
		Role role2 = new Role("ROLE_ADMIN");
		roleService.addRole(role1);
		roleService.addRole(role2);
		// Crear perfiles
		User user1 = new User("Pedro", "Díaz", "99999990A@uniovi.es", "caca");
		user1.setRole(roleService.getRoleByType("ROLE_REGISTERED"));
		User user2 = new User("Lucas", "Núñez", "99999991B@uniovi.es", "pedo");
		user2.setRole(roleService.getRoleByType("ROLE_REGISTERED"));
		User user3 = new User("María", "Rodríguez", "99999992C@uniovi.es", "culo");
		user3.setRole(roleService.getRoleByType("ROLE_REGISTERED"));
		User user4 = new User("Marta", "Almonte", "99999993D@uniovi.es", "me");
		user4.setRole(roleService.getRoleByType("ROLE_REGISTERED"));
		User user5 = new User("Pelayo", "Valdes", "99999977E@uniovi.es", "aburro");
		user5.setRole(roleService.getRoleByType("ROLE_REGISTERED"));
		User user6 = new User("Yo", "Alejandro", "admin@email.com", "admin");
		user6.setRole(roleService.getRoleByType("ROLE_ADMIN"));

		usersService.addUser(user1);
		usersService.addUser(user2);
		usersService.addUser(user3);
		usersService.addUser(user4);
		usersService.addUser(user5);
		usersService.addUser(user6);

		// Pedir amistad
		friendRequestService.addFriendRequest(user3, user1);
		friendRequestService.addFriendRequest(user1, user6);
		friendRequestService.addFriendRequest(user4, user1);

		publicationService.addPublication(
				new Publication(user2, "Prueba Publicación", "Esta es una publicación de prueba", null));

		// Forzar amistad
		friendshipService.addFriendship(user1, user2);
	}
}