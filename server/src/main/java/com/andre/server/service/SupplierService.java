package com.andre.server.service;

import com.andre.server.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    public List<SupplierDTO> getAllSupplier();

    public SupplierDTO getSupplierByName(String name);

}
