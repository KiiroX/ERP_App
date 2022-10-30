package com.andre.server.controller;

import com.andre.server.dto.ItemDTO;
import com.andre.server.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("item")
    public List<ItemDTO> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("item/{itemCode}")
    public ItemDTO getItemByCode(@PathVariable("itemCode") long itemCode) { return itemService.getItemByCode(itemCode); }

}
