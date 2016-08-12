package com.vig.shop.service;

import com.vig.shop.model.Register;
import com.vig.shop.model.UserDetails;

public interface LoginService {

	public boolean checkUser(UserDetails u);

	boolean checkUser(Register r);

}
