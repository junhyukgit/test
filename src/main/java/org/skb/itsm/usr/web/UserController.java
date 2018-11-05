package org.skb.itsm.usr.web;

import java.util.HashMap;
import java.util.List;

import org.skb.itsm.usr.dto.UserDTO;
import org.skb.itsm.usr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserController {

	@Autowired
    private UserRepository userRepository;
	
	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
	

	
	@RequestMapping("/login")
	public void userLogin() throws Exception{
		
		List<UserDTO> list = userRepository.getUserList();
		
		System.out.println(list.get(0).getName());
		
	}
	
	 @RequestMapping(path = "/getUser")
	 public HashMap<String, Object> getUser() throws Exception {
	       
		 HashMap<String,Object> map = new HashMap<String, Object>();
	        
	        List<UserDTO> user = userRepository.getUserList();
	        
	        map.put("list", user);
	        System.out.println(map.get("list"));
	        
	    return map;
	 }
	 
	 @RequestMapping(path="/users")
	    public HashMap<String, Object> getUserById(@RequestParam String name) throws Exception {
		 HashMap<String,Object> map = new HashMap<String, Object>();
	        System.out.println("~~~~"+name);
	        List<UserDTO> user = userRepository.getUserSearch(name);
	        
	        map.put("list", user);
	        System.out.println(map.get("list"));
	        
	    return map;
	 }
	
    @RequestMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        System.out.println("GET called on /hello resource");
        return HELLO_TEXT;
    }
	
	
}
