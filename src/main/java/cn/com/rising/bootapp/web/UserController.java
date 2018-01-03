package cn.com.rising.bootapp.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.rising.bootapp.config.UserConfigBean;
import cn.com.rising.bootapp.entity.User;
import cn.com.rising.bootapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConfigBean userConfigBean;
	
	@GetMapping("/user/get/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		System.out.println("===getUserById id "+id);
		return userService.getUserById(id);
	}
	
	@GetMapping("/user/get")
	public List<User> getUsers() {
		System.out.println("===getUsers");
		return userService.getUsers();
	}
	
	@PostMapping("/user/add")
	public void addUser(@RequestBody User user) {
		System.out.println("===addUsers　"+user.toString());
		user.setDate(new Date());
		userService.addUser(user);
	}
	
	@PostMapping("/user/delete")
	public void deleteUser(@RequestParam(value = "id", required = true) Integer id) {
		System.out.println("===deleteUsers　"+id);
		userService.deleteUserById(id);
	}
	
	@PostMapping("/user/update")
	public void updateUser(@RequestBody User user) {
		System.out.println("===updateUsers　"+user.toString());
		user.setDate(new Date());
		userService.updateUser(user);
	}
}
