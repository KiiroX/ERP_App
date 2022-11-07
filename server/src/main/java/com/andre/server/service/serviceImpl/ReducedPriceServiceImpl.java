package com.andre.server.service.serviceImpl;

import com.andre.server.dto.ReducedPriceDTO;
import com.andre.server.model.ReducedPrice;
import com.andre.server.repository.ReducedPriceRepository;
import com.andre.server.service.ReducedPriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<ReducedPriceDTO> getReducedPriceByItem(long itemCode) {

        List<ReducedPriceDTO> result = new ArrayList<>();
        List<ReducedPriceDTO> priceDTOList = getAllReducedPrice();

        for(ReducedPriceDTO priceDTO : priceDTOList) {
            if(priceDTO.getItem().getItemCode() == itemCode) {
                result.add(priceDTO);
            }
        }

        return result;

    }

    @Override
    public ResponseEntity<ReducedPrice> saveReducedPrice(ReducedPrice price) {
        priceRepository.save(price);
        return new ResponseEntity<ReducedPrice>(price, null, HttpStatus.CREATED);
    }

    @Override
    public void deleteReducedPrice(long itemCode) {

        List<ReducedPriceDTO> priceDTOList = getReducedPriceByItem(itemCode);

        for(ReducedPriceDTO priceDTO : priceDTOList) {
            priceRepository.deleteById(priceDTO.getIdReducedPrice());
        }

    }

}
