package com.sample.dao;

import java.util.List;

import com.sample.dto.Login;

public interface LoginDao {
public boolean isValid(String username, String password);
public List<Login> showList();
}
