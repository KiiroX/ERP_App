package com.andre.server.service;

import com.andre.server.dto.ItemDTO;
import com.andre.server.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    public List<ItemDTO> getAllItem();

    public  ItemDTO getItemByCode(long itemCode);

    public ResponseEntity<Item> saveItem(Item item);

    public ResponseEntity<ItemDTO> updateItem(ItemDTO itemDTO);

}
