package com.mycompany;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.mycompany.entity.User;
import com.mycompany.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * @Test public void testAddNew() { User user = new User();
	 * user.setEmail("nguyenthianhthu@lovepopvn.com");
	 * user.setPassword("123456789"); user.setFirstName("Nguyen");
	 * user.setLastName("Thu"); User savedUser = userRepository.save(user);
	 * 
	 * Assertions.assertThat(savedUser).isNotNull();
	 * Assertions.assertThat(savedUser.getId()).isGreaterThan(0); }
	 */
	
	@Test
	public void testAllUsers() {
		Iterable<User> users = userRepository.findAll();
		Assertions.assertThat(users).hasSizeGreaterThan(0);
		
		for(User user : users) {
			System.out.println(user);
		}
	}
	
	/*
	 * @Test public void updateUser() { Integer userId = 1; Optional<User> user =
	 * userRepository.findById(userId); if(user.isPresent() == false) {
	 * System.out.println("Can not find a user with id: " + userId); } User
	 * updateUser = user.get(); updateUser.setPassword("88888888");
	 * userRepository.save(updateUser);
	 * 
	 * User updatedUser = userRepository.findById(userId).get();
	 * Assertions.assertThat(updatedUser.getPassword()).isEqualTo("88888888"); }
	 */
	
	/*
	 * @Test public void testDelete() { Integer userId = 2;
	 * userRepository.deleteById(userId); Optional<User> optionalUser =
	 * userRepository.findById(userId);
	 * Assertions.assertThat(optionalUser).isNotPresent(); }
	 */
}
