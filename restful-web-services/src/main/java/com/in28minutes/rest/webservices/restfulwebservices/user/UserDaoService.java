package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 3;
	
	static {
		getUsers().add(new User(1, "Adam", new Date()));
		getUsers().add(new User(2, "Eve", new Date()));
		getUsers().add(new User(3, "Jack", new Date()));
	}
	
	public List<User> findAll() {
		return getUsers();
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		getUsers().add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user: getUsers()) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = UserDaoService.users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		UserDaoService.users = users;
	}
}
