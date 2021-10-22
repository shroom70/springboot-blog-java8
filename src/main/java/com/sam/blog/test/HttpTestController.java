package com.sam.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpTestController {
	
	private static final String TAG = "HttpTestController : ";
	
//	@GetMapping("/http/lombok")
//	public String lombokTest() {
//		Member m = new Member(1, "ssar", "1234", "email");
//		System.out.println(TAG+"getter : "+m.getId());
//		m.setId(5000);
//		System.out.println(TAG+"setter : " + m.getId());
//		return "lombok test 완료!!";
//	}
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//builder 패턴의 장점 : 생성자에서처럼 파라미터의 순서를 지키지 않아도 되기 때문에 편리함
		Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG+"getter : "+m.getUsername());
		m.setUsername("sam");
		System.out.println(TAG+"setter : " + m.getUsername());
		return "lombok test 완료!!";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword()+ ", " + m.getEmail();
	}
	
//	@PostMapping("/http/post")
//	public String postTest(@RequestBody String msg) {
//		return "post 요청 : " + msg;
//	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword()+ ", " + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + ", " + m.getPassword();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
