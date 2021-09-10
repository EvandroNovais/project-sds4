package com.evandro.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evandro.dsvendas.dto.SaleDTO;
import com.evandro.dsvendas.dto.SaleSuccessDTO;
import com.evandro.dsvendas.dto.SaleSumDTO;
import com.evandro.dsvendas.entities.Sale;
import com.evandro.dsvendas.repositories.SaleRepository;
import com.evandro.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable page){
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(page);
		return result.map(x -> new SaleDTO(x));
	}
	
	public List<SaleSumDTO> amountGroupedBySeller(){
		return saleRepository.amountGroupedBySeller();
	}
	
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return saleRepository.successGroupedBySeller();
	}
}
