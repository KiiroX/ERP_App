package com.andre.server.service;

import com.andre.server.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    public List<ItemDTO> getAllItem();

    public  ItemDTO getItemByCode(long itemCode);

}
