package com.evandro.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evandro.dsvendas.dto.SellerDTO;
import com.evandro.dsvendas.entities.Seller;
import com.evandro.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = sellerRepository.findAll();
		return result .stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
