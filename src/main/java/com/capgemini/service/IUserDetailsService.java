package com.capgemini.service;
import java.util.List;
import com.capgemini.entities.UserDetails;
import com.capgemini.exception.UserDetailsException;
public interface IUserDetailsService {
UserDetails createUserDetails(UserDetails userDetails) throws UserDetailsException;
String updateUserDetails(int user_id,UserDetails userDetails) throws UserDetailsException;
UserDetails findUserDetailsById(int user_id) throws UserDetailsException;
List<UserDetails> getRequest() throws UserDetailsException;
String deleteUserDetails(int user_id) throws UserDetailsException;
UserDetails logIn(String name,String password,String userType)throws UserDetailsException;
}