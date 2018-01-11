package org.sun.bootapp.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sun.bootapp.annotation.Log;
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
	
	@Log
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		logger.debug("===getUserById id "+id);
		return userService.getUserById(id);
	}
	
	@GetMapping("/user")
	public List<User> getUsers() {
		logger.debug("===getUsers");
		return userService.getUsers();
	}
	
	@PostMapping("/user")
	public int addUser(@RequestBody User user) {
		user.setDate(new Date());
		userService.addUser(user);
		logger.debug("===addUsers　"+user.toString());
		return user.getId();
	}
	
	@DeleteMapping("/user/{id}")
	public int removeUser(@PathVariable("id") Integer id) {
		logger.debug("===removeUser　"+id);
		return userService.removeUserById(id);
	}
	
	@PutMapping("/user")
	public int updateUser(@RequestBody User user) {
		user.setDate(new Date());
		int result = userService.updateUser(user);
		logger.debug("===updateUsers　"+user.toString() + " result "+result);
		return result;
	}
}
