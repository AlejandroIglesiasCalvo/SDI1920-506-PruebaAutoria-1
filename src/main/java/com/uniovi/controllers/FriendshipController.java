package com.uniovi.controllers;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.entities.Friendship;
import com.uniovi.entities.Publication;
import com.uniovi.entities.User;
import com.uniovi.services.FriendRequestService;
import com.uniovi.services.FriendshipService;
import com.uniovi.services.LoggerService;
import com.uniovi.services.UsersService;

@Controller
public class FriendshipController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private FriendshipService friendshipService;

	private LoggerService logger = new LoggerService(this);

	@RequestMapping("/user/friends")
	public String showFriends(Model model, Pageable pageable, Principal principal) {
		String email = principal.getName();
		User loggedInUser = usersService.getUserByEmail(email);
		Page<Friendship> friends = new PageImpl<Friendship>(new LinkedList<Friendship>());
		friends = friendshipService.findByUser(pageable, loggedInUser);
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("friends", friends.getContent());
		model.addAttribute("page", friends);
		logger.infoLog("The user with email: " + loggedInUser.getEmail() + " has listed their friend list.");
		return "user/friends";
	}

	@RequestMapping("/favoritos/{id}")
	public String addFavorito(Model model, @PathVariable Long id, Pageable pageable) {
		User user=usersService.getUser(id);
		model.addAttribute("user", user);//La paginacion
		return "user/favoritos";
	}
	
	@RequestMapping("/Borrarfavoritos/{id}")
	public String DeleteFavorito(Model model, @PathVariable Long id, Pageable pageable) {
		return "user/favoritos";
	}
}

