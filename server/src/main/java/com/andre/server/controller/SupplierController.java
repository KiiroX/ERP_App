package com.andre.server.controller;

import com.andre.server.dto.SupplierDTO;
import com.andre.server.model.Supplier;
import com.andre.server.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
@CrossOrigin("http://localhost:3000")
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

    @PostMapping("addSupplier")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

}
