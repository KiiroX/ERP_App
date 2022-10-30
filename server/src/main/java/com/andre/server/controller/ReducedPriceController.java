package com.andre.server.controller;

import com.andre.server.dto.ReducedPriceDTO;
import com.andre.server.service.ReducedPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("price")
public class ReducedPriceController {

    @Autowired
    ReducedPriceService priceService;

    @GetMapping("price")
    public List<ReducedPriceDTO> getAllReducedPrice() {
        return priceService.getAllReducedPrice();
    }

    @GetMapping("price/{itemCode}")
    public ReducedPriceDTO getReducedPriceByItem(@PathVariable("itemCode") long itemCode) {
        return priceService.getReducedPriceByItem(itemCode);
    }

}
