package com.andre.server.service.serviceImpl;

import com.andre.server.dto.SupplierDTO;
import com.andre.server.model.Supplier;
import com.andre.server.repository.SupplierRepository;
import com.andre.server.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Supplier/*DTO*/> getAllSupplier() {

        List<Supplier> supplierList = new ArrayList<>();
        List<SupplierDTO> supplierDTOList = new ArrayList<>();

        supplierRepository.findAll().forEach(supplier -> supplierList.add(supplier));

        for(Supplier supplier : supplierList) {
            supplierDTOList.add(modelMapper.map(supplier, SupplierDTO.class));
        }

        return supplierList;

    }

    @Override
    public SupplierDTO getSupplierByName(String name) {

//        List<SupplierDTO> supplierDTOList;
//        supplierDTOList = getAllSupplier();
//
//        for(SupplierDTO supplierDTO : supplierDTOList) {
//            if(supplierDTO.getName().equalsIgnoreCase(name)) {
//                return supplierDTO;
//            }
//        }

        return null;

    }

    @Override
    public ResponseEntity<Supplier> saveSupplier(Supplier supplier) {
        supplierRepository.save(supplier);
        return new ResponseEntity<Supplier>(supplier, null, HttpStatus.CREATED);
    }

}
