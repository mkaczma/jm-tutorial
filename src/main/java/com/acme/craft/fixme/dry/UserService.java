package com.acme.craft.fixme.dry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Collection;

public class UserService {

	public HashSet doSomethingDifferent(List<User> users) {
		HashSet<String> usrnms = new HashSet<String>();
		for (int i = users.size(); i >= 0; i--) {
			if (users.get(i).getAge() > 18) {
				String temp = users.get(i).getFullName();
				usrnms.add(temp);
			}
		}
		return usrnms;
	}
}
