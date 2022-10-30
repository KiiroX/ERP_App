package com.andre.server.service;

import com.andre.server.dto.ReducedPriceDTO;

import java.util.List;

public interface ReducedPriceService {

    public List<ReducedPriceDTO> getAllReducedPrice();

    public ReducedPriceDTO getReducedPriceByItem(long itemCode);

}
