package com.andre.server.controller;

import com.andre.server.dto.ReducedPriceDTO;
import com.andre.server.model.ReducedPrice;
import com.andre.server.service.ReducedPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
public class ReducedPriceController {

    @Autowired
    private ReducedPriceService priceService;

    @GetMapping("price")
    public List<ReducedPriceDTO> getAllReducedPrice() {
        return priceService.getAllReducedPrice();
    }

    @GetMapping("price/{itemCode}")
    public List<ReducedPriceDTO> getReducedPriceByItem(@PathVariable("itemCode") long itemCode) {
        return priceService.getReducedPriceByItem(itemCode);
    }

    @PostMapping("addPrice")
    public ResponseEntity<ReducedPrice> saveReducedPrice(@RequestBody ReducedPrice reducedPrice) {
        return priceService.saveReducedPrice(reducedPrice);
    }

    @DeleteMapping("deletePrice/{itemCode}")
    public void deleteReducedPrice(@PathVariable("itemCode") long itemCode) {
        priceService.deleteReducedPrice(itemCode);
    }

}
