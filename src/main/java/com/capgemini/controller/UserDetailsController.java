package com.capgemini.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserDetailsException;
import com.capgemini.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin
public class UserDetailsController {

	@Autowired
	private UserDetailsServiceImpl userdetailserviceimpl;
	
	@PostMapping("/")
	public ResponseEntity<UserDetails> create(@RequestBody UserDetails userdetails) throws UserDetailsException {
		UserDetails user=userdetailserviceimpl.createUserDetails(userdetails);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/{user_id}")
	public ResponseEntity<String> update(@PathVariable int user_id,@RequestBody UserDetails userdetails) throws UserDetailsException {
			String message= userdetailserviceimpl.updateUserDetails(user_id, userdetails);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
	@GetMapping("/{user_id}")
	public ResponseEntity<UserDetails> findById(@PathVariable int user_id) throws UserDetailsException {
		UserDetails user=userdetailserviceimpl.findUserDetailsById(user_id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDetails>> getRequest() throws UserDetailsException{
		List<UserDetails> user=userdetailserviceimpl.getRequest();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{user_id}")
	public ResponseEntity<String> deleteUser(@PathVariable int user_id) throws UserDetailsException {
		String message= userdetailserviceimpl.deleteUserDetails(user_id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	@PostMapping("/login/")
	public ResponseEntity<UserDetails> login(@RequestBody UserDetails userdetails) throws UserDetailsException {
		UserDetails user=userdetailserviceimpl.logIn(userdetails.getUserName(),userdetails.getUserPassword(),userdetails.getUserType());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}