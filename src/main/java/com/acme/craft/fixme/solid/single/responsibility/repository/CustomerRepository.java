package com.acme.craft.fixme.solid.single.responsibility.repository;

import com.acme.craft.fixme.solid.utils.ErrorUtils;

import lombok.extern.java.Log;

@Log
public class CustomerRepository {

	public void add() {
		try {
			/*
			 * do some database stuff here
			 */
		} catch (Exception e) {
			ErrorUtils.handleError("database error");
		}
	}

}
