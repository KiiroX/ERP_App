package com.andre.server.controller;

import com.andre.server.dto.ItemDTO;
import com.andre.server.model.Item;
import com.andre.server.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
@CrossOrigin("http://localhost:3000")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("item")
    public List<ItemDTO> getAllItem() {
        return itemService.getAllItem();
    }

    @GetMapping("item/{itemCode}")
    public ItemDTO getItemByCode(@PathVariable("itemCode") long itemCode) { return itemService.getItemByCode(itemCode); }

    @PostMapping("addItem")
    public void saveItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @PutMapping("updateitem")
    public ResponseEntity<ItemDTO> updateItem(@RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(itemDTO);
    }
}
