package com.acme.craft.fixme.cleancode;

import java.util.Set;

public interface ResourceHolderResourceRepository {

	Resource findOne(Object contentId);

	Iterable<Resource> findAll(Set<String> resourceIds);

}
