package com.vig.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vig.shop.dao.RegisterDAO;
import com.vig.shop.model.Register;


@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{
	
	
	
	
	@Autowired RegisterDAO registerDAO;
	@Override
	public void saveOrUpdate(Register regs) {
		// TODO Auto-generated method stub
		registerDAO.saveOrUpdate(regs);
	}
}
