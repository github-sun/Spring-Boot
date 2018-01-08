package org.sun.bootapp.dao;

import java.util.List;

import org.sun.bootapp.entity.User;

public interface UserJdbcDAO {

	List<User> getUsers();
}
