package com.andre.server.service;

import com.andre.server.dto.SupplierDTO;
import com.andre.server.model.Supplier;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {

    public List<SupplierDTO> getAllSupplier();

    public SupplierDTO getSupplierByName(String name);

    public ResponseEntity<Supplier> saveSupplier(Supplier supplier);

    public ResponseEntity<Supplier> updateSupplier(Supplier supplier);

}
