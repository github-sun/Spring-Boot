package org.sun.bootapp.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sun.bootapp.config.UserConfigBean;
import org.sun.bootapp.entity.User;
import org.sun.bootapp.service.UserService;

@RestController
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConfigBean userConfigBean;
	
	@GetMapping("/user/get/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		//System.out.println("===getUserById id "+id);
		logger.debug("===getUserById id "+id);
		return userService.getUserById(id);
	}
	
	@GetMapping("/user/get")
	public List<User> getUsers() {
		//System.out.println("===getUsers");
		logger.debug("===getUsers");
		return userService.getUsers();
	}
	
	@PostMapping("/user/add")
	public int addUser(@RequestBody User user) {
		//System.out.println("===addUsers　"+user.toString());
		user.setDate(new Date());
		userService.addUser(user);
		logger.debug("===addUsers　"+user.toString());
		return user.getId();
	}
	
	@PostMapping("/user/delete")
	public void removeUser(@RequestParam(value = "id", required = true) Integer id) {
		//System.out.println("===deleteUsers　"+id);
		logger.debug("===removeUser　"+id);
		userService.removeUserById(id);
	}
	
	@PostMapping("/user/update")
	public void updateUser(@RequestBody User user) {
		//System.out.println("===updateUsers　"+user.toString());
		logger.debug("===updateUsers　"+user.toString());
		user.setDate(new Date());
		userService.updateUser(user);
	}
}
