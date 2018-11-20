package com.bank.restapi.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.restapi.model.Banks;
import com.bank.restapi.repository.BanksRepository;
@Transactional
@Service
public class BanksDAO {
	@Autowired
	BanksRepository banksRepository;
	
	public Banks findByIfsc(String ifsc) 
	{
	return banksRepository.findByIfsc(ifsc);
	}
}
