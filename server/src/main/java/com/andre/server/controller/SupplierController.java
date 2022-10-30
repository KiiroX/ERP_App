package com.andre.server.controller;

import com.andre.server.dto.SupplierDTO;
import com.andre.server.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("supplier")
    public List<SupplierDTO> getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    @GetMapping("supplier/{name}")
    public SupplierDTO getSupplierByName(@PathVariable("name") String name) {
        return supplierService.getSupplierByName(name);
    }

}
