package com.andre.server.service.serviceImpl;

import com.andre.server.dto.ItemDTO;
import com.andre.server.model.Item;
import com.andre.server.repository.ItemRepository;
import com.andre.server.service.ItemService;
import com.andre.server.service.ReducedPriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReducedPriceService reducedPriceService;

    @Override
    public List<ItemDTO> getAllItem() {

        List<Item> itemList = new ArrayList<>();
        List<ItemDTO> itemDTOList = new ArrayList<>();

        itemRepository.findAll().forEach(item -> itemList.add(item));

        for(Item item : itemList) {
            itemDTOList.add(modelMapper.map(item, ItemDTO.class));
        }

        return itemDTOList;

    }

    @Override
    public ItemDTO getItemByCode(long itemCode) {

        List<ItemDTO> itemDTOList;
        itemDTOList = getAllItem();

        for(ItemDTO itemDTO : itemDTOList) {
            if(itemDTO.getItemCode() == itemCode) {
                return itemDTO;
            }
        }

        return null;

    }

    @Override
    public ResponseEntity<Item> saveItem(Item item) {
        itemRepository.save(item);
        return new ResponseEntity<Item>(item, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Item> updateItem(Item item) {

        ItemDTO itemDTO = null;
        itemDTO = getItemByCode(item.getItemCode());

        if(itemDTO != null) {
            itemRepository.save(item);
        }

        return new ResponseEntity<Item>(item, HttpStatus.CREATED);

    }

    @Override
    public void deleteItem(long itemCode) {

        ItemDTO itemDTO = getItemByCode(itemCode);

        reducedPriceService.deleteReducedPrice(itemCode);
        itemRepository.deleteById(itemDTO.getIdItem());

    }

}
