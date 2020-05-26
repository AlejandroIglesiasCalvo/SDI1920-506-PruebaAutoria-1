package com.uniovi.controllers;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uniovi.entities.User;
import com.uniovi.services.FriendshipService;
import com.uniovi.services.LoggerService;
import com.uniovi.services.SecurityService;
import com.uniovi.services.UsersService;
import com.uniovi.validators.SignUpFormValidator;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;//El servicio de usuarios

	@Autowired
	FriendshipService friendshipService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SignUpFormValidator signUpFormValidator;

	private LoggerService logger = new LoggerService(this);

	@RequestMapping(value = "/login")//Para loggin
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {//Requiere que no tenga errores
		if (error != null)
			model.addAttribute("error", true);
		return "login";//Retorna la vista login
	}

	@RequestMapping(value = "/home")//Para ir a home
	public String home(Model model) {//Solo necesita el modelo con los datos que ya tiene, sin parametros
		return "home";//Retorna a home
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)//Peticion get para registrarse
	public String signup(Model model) {
		model.addAttribute("user", new User());//añade un usuario nuevo al modelo
		return "signup";//retornando la vista de registro
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)//En el post del metodo anterior
	public String setUser(@ModelAttribute @Validated User user, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {//Requiere un usuario con datos validos
		signUpFormValidator.validate(user, result);//Se validan los datos
		if (result.hasErrors()) {
			return "signup";//Si tiene errores, se reenvia a la misma vista
		}
		usersService.addUser(user);//Si va bien, se guarda el usuario
		logger.infoLog("New user was created with Email: " + user.getEmail() + ".");//Irrelevante
		securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());//Añadimos el rol de login al usuario
		redirectAttributes.addFlashAttribute("success", true);//Todo fue correcto
		logger.infoLog("The user with email: " + user.getEmail() + " has accessed the system.");//Irrelevante
		return "redirect:home";//redirigimos a home
	}

	@RequestMapping("/user/list")
	public String getListado(Model model, Pageable pageable, Principal principal,
			@RequestParam(value = "", required = false) String searchText) {//Puede requerir texto
		String email = principal.getName();
		User loggedInUser = usersService.getUserByEmail(email);//El usuario que esta realizando la busqueda
		Page<User> users = new PageImpl<User>(new LinkedList<User>());//Creamos como sacar los usuarios
		if (searchText != null && !searchText.isEmpty())//Si tiene texto de busqueda, buscamos
			users = usersService.searchUserByNameAndEmail(searchText, pageable);//Buscamos el texto
		else
			users = usersService.getUsers(loggedInUser, pageable);//buscamos todos menos el actual
		List<User> usersNotFriends = usersService.searchNotFriendsNorRequestedUsers(loggedInUser);//Sin poeticion o sin ser amigos
		model.addAttribute("usersNotFriends", usersNotFriends);//Añadimos en orden los que no son amigos	
		model.addAttribute("loggedInUser", loggedInUser);//Quien realiza la busqueda
		model.addAttribute("usersList", users.getContent());//Los demas usuarios
		model.addAttribute("page", users);//La paginacion
		model.addAttribute("listAction", true);
		logger.infoLog("The user with email: " + loggedInUser.getEmail() + " has listed the users of the system.");
		return "user/list";//devolvemos la vista lista
	}

	@RequestMapping("/user/list/update")//Actualiazcion de la lista
	public String updateList(Model model, Pageable pageable, Principal principal) {
		String email = principal.getName();
		User loggedInUser = usersService.getUserByEmail(email);//Igual que la anterior
		Page<User> users = new PageImpl<User>(new LinkedList<User>());//Creamos como sacar los usuarios
		users = usersService.getUsers(loggedInUser, pageable);//llenamos la lista
		//Usuarios que no son amigos y no nos pidieron amistad
		List<User> usersNotFriends = usersService.searchNotFriendsNorRequestedUsers(loggedInUser);
		model.addAttribute("usersNotFriends", usersNotFriends);
		model.addAttribute("loggedInUser", loggedInUser);
		model.addAttribute("usersList", users.getContent());
		return "user/list :: tableUsers";
	}

}
