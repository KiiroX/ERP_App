package com.andre.server.service.serviceImpl;

import com.andre.server.dto.ReducedPriceDTO;
import com.andre.server.model.ReducedPrice;
import com.andre.server.repository.ReducedPriceRepository;
import com.andre.server.service.ReducedPriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReducedPriceServiceImpl implements ReducedPriceService {

    @Autowired
    private ReducedPriceRepository priceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReducedPriceDTO> getAllReducedPrice() {

        List<ReducedPrice> priceList = new ArrayList<>();
        List<ReducedPriceDTO> priceDTOList = new ArrayList<>();

        priceRepository.findAll().forEach(price -> priceList.add(price));

        for (ReducedPrice price : priceList) {
            priceDTOList.add(modelMapper.map(price, ReducedPriceDTO.class));
        }

        return priceDTOList;

    }

    @Override
    public ReducedPriceDTO getReducedPriceByItem(long itemCode) {

        List<ReducedPriceDTO> priceDTOList;
        priceDTOList = getAllReducedPrice();

        for(ReducedPriceDTO priceDTO : priceDTOList) {
            if(priceDTO.getItem().getItemCode() == itemCode) {
                return priceDTO;
            }
        }

        return null;

    }

}
