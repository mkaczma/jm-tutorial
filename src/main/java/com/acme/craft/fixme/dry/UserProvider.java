package com.acme.craft.fixme.dry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserProvider {

	public Set<String> doSomething(List<User> userListCollection) {
		Set<String> userNames = new HashSet<String>();
		for (User user : userListCollection) {
			if (user.getAge() > 18) {
				userNames.add(user.getFullName());
			}
		}
		return userNames;
	}

}
