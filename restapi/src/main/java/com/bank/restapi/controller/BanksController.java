package com.bank.restapi.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.bank.restapi.dao.InterfaceDAO;
import com.bank.restapi.model.Banks;

@RestController
@RequestMapping("/banks")
public class BanksController {

    @Autowired
    InterfaceDAO banksDAO;
        
    /*get banks details by ifsc*/
	@GetMapping("/bank_branches/{ifsc}")
	@ResponseBody
	public ResponseEntity<Banks> getByIfsc(@PathVariable String ifsc)
	{
		Banks bank;
		  try {
		    bank = banksDAO.findByIfsc(ifsc);
		  }
		  catch (Exception ex) {
		    return ResponseEntity.notFound().build();
		  }
		  return ResponseEntity.ok().body(bank);

	}
	
	@GetMapping("/bank_branches/{bname}/{city}")
	@ResponseBody
	public ResponseEntity<List<Banks>> getByName(@PathVariable String bname, @PathVariable String city){
		List<Banks> bank;
		List<Banks> banks = new ArrayList<Banks>();
		try {
			bank = banksDAO.findBybankNameAndCity(bname, city);
			for (Banks e : bank) {
				banks.add(e);
			}
		}
		catch (Exception ex)
		{
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(banks);
	}
}


