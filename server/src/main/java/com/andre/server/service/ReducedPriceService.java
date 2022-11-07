package com.andre.server.service;

import com.andre.server.dto.ReducedPriceDTO;
import com.andre.server.model.ReducedPrice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReducedPriceService {

    public List<ReducedPriceDTO> getAllReducedPrice();

    public List<ReducedPriceDTO> getReducedPriceByItem(long itemCode);

    public ResponseEntity<ReducedPrice> saveReducedPrice(ReducedPrice price);

    public void deleteReducedPrice(long itemCode);

}
