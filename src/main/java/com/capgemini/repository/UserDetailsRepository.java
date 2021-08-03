package com.capgemini.repository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.capgemini.entities.UserDetails;
public interface UserDetailsRepository extends JpaRepository<UserDetails,Integer> {
	@Transactional
	@Modifying
	@Query(value = "DELETE from UserDetails where is_deleted = true")
	void deleteUserDetailsByIsDelete(boolean isDeleted);
	boolean existsByUserName(String name);
	UserDetails findByUserNameAndUserPassword(String name,String password);
}