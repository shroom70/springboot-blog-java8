package com.sam.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.blog.model.RoleType;
import com.sam.blog.model.User;
import com.sam.blog.repository.UserRepository;

@RestController
public class DummyTestController {
	
	@Autowired
	private UserRepository userRepository;
	
//	@PostMapping("/dummy/join")
//	public String dummyJoin(String username, String password, String email) {
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
//		System.out.println("email : " + email);
//		return "회원가입이 완료되었습니다.";
//	}
	
	@PostMapping("/dummy/join")
	public String dummyJoin(User user) {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
	
	@GetMapping("/dummy/user/{id}")
	public User dummyJoin(@PathVariable int id) {	

//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//									@Override
//									public User get() {
//										return new User();
//									}
//								});
//		User user = userRepository.findById(id).orElseGet(() -> {
//									return new User();
//								});
//		User user = userRepository.findById(id).orElseThrow(() -> {
//									return new IllegalArgumentException("해당 사용자가 없습니다. id : " + id);
//								});
	
		User user = userRepository.findById(id).orElseThrow(
								new Supplier<IllegalArgumentException>() {
									@Override
									public IllegalArgumentException get() {
										return new IllegalArgumentException("해당 사용자가 없습니다. id : " + id);
									}
								});
		
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
//	@GetMapping("/dummy/user")
//	public Page<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC) Pageable pageable) {
//		Page<User> pageUsers = userRepository.findAll(pageable);
//		return pageUsers;
//	}
	
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC) Pageable pageable) {
		Page<User> pageUsers = userRepository.findAll(pageable);
		List<User> users = pageUsers.getContent();
		return users;
	}
}
