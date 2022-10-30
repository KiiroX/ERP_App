package com.andre.server.repository;

import com.andre.server.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> { }