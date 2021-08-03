package com.capgemini.service;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserDetailsException;
import com.capgemini.repository.UserDetailsRepository;
@Service
public class UserDetailsServiceImpl implements IUserDetailsService {
	@Autowired
	private UserDetailsRepository userdetailrepository;
	@Override
	public UserDetails createUserDetails(UserDetails userDetails) throws UserDetailsException {
		if(userdetailrepository.existsByUserName(userDetails.getUserName())) {
			throw new UserDetailsException("user_name already exists");
		}
		if(!userDetails.getUserName().matches("[a-zA-Z0-9 ]+")) {
			throw new UserDetailsException("User name is invalid");
		}
		if(!userDetails.getUserEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			throw new UserDetailsException("Email is invalid");
		}
		if(!userDetails.getUserMobile().matches("[6-9][0-9]{9}")) {
			throw new UserDetailsException("mobile number is invalid");
		}
		if(!userDetails.getUserPassword().matches("[a-zA-z0-9@#!$*&^%]{8,12}")) {
			throw new UserDetailsException("User password is Invalid");
		}
		if(!(userDetails.getUserType().equalsIgnoreCase("user")||userDetails.getUserType().equalsIgnoreCase("admin"))) {
			throw new UserDetailsException("user type is invalid");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		userDetails.create_Date_Time = java.time.LocalDateTime.now().format(formatter);
		userDetails.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		userdetailrepository.save(userDetails);
		return userDetails;
	}

	@Override
	public String updateUserDetails(int user_id, UserDetails userDetails) throws UserDetailsException {
		if(userdetailrepository.existsByUserName(userDetails.getUserName())) {
			throw new UserDetailsException("user_name already exists");
		}
		if(!userDetails.getUserName().matches("[a-zA-Z0-9 ]+")) {
			throw new UserDetailsException("User name is invalid");
		}
		if(!userDetails.getUserEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			throw new UserDetailsException("Email is invalid");
		}
		if(!userDetails.getUserMobile().matches("[6-9][0-9]{9}")) {
			throw new UserDetailsException("mobile number is invalid");
		}
		if(!userDetails.getUserPassword().matches("[a-zA-z0-9@#!$*&%]{8,12}")) {
			throw new UserDetailsException("User password is Invalid");
		}
		if(!(userDetails.getUserType().equalsIgnoreCase("user")||userDetails.getUserType().equalsIgnoreCase("admin"))) {
			throw new UserDetailsException("user type is invalid");
		}
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		if(dbUser!=null) {
			dbUser.setUserName(userDetails.getUserName());
			dbUser.setUserEmail(userDetails.getUserEmail());
			dbUser.setUserMobile(userDetails.getUserMobile());
			dbUser.setUserPassword(userDetails.getUserPassword());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			userDetails.update_Date_Time = java.time.LocalDateTime.now().format(formatter);
		}
			userdetailrepository.save(dbUser);
			return "User Details Updated!!!";
	}
	@Override
	public UserDetails findUserDetailsById(int user_id) throws UserDetailsException {
		if(!userdetailrepository.existsById(user_id)) {
			throw new UserDetailsException("user_id is not exists");
		}
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		if(dbUser.isDeleted==true) {
			throw new UserDetailsException("User deleted from the data");
		}
		return(dbUser);
	}
	@Override
	public List<UserDetails> getRequest() throws UserDetailsException {
		List<UserDetails> userdetails=userdetailrepository.findAll().stream()
				.filter((p1)->p1.isDeleted==false)
				.collect(Collectors.toList());
		if(userdetails.isEmpty()) {
			throw new UserDetailsException("user details data is empty");
		}
		return userdetails;
	}
	@Override
	public String deleteUserDetails(int user_id) throws UserDetailsException {
		if(!userdetailrepository.existsById(user_id)) {
			throw new UserDetailsException("user_id is not exists");
		}
		UserDetails dbUser=userdetailrepository.findById(user_id).get();
		if(dbUser.isDeleted == false) {
			dbUser.isDeleted = true;
			userdetailrepository.save(dbUser);
		}
		return "User Details Deleted";
	}

	@Override
	public UserDetails logIn(String name, String password,String userType) throws UserDetailsException {
		if(!userdetailrepository.existsByUserName(name)) {
			throw new UserDetailsException("username does not exists");
		}
		UserDetails dbUser=userdetailrepository.findByUserNameAndUserPassword(name, password);
		if(dbUser.isDeleted==true || !(dbUser.getUserType().equalsIgnoreCase(userType))) {
			throw new UserDetailsException("username does not exists");
		}
		return dbUser;
	}



}