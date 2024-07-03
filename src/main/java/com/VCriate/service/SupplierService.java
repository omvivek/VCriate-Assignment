package com.VCriate.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VCriate.model.RestockOrder;
import com.VCriate.model.Supplier;
import com.VCriate.repository.RestockOrderRepository;
import com.VCriate.repository.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private RestockOrderRepository restockOrderRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Optional<Supplier> existingSupplierOptional = supplierRepository.findById(id);
        if (existingSupplierOptional.isPresent()) {
            Supplier existingSupplier = existingSupplierOptional.get();
            existingSupplier.setName(updatedSupplier.getName());
            existingSupplier.setContactInfo(updatedSupplier.getContactInfo());
            return supplierRepository.save(existingSupplier);
        }
        return null; // Or throw an exception indicating supplier not found
    }

    public void removeSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public RestockOrder placeRestockOrder(Long supplierId, RestockOrder restockOrder) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(supplierId);
        if (supplierOptional.isPresent()) {
            restockOrder.setSupplierId(supplierId);
            return restockOrderRepository.save(restockOrder);
        }
        return null; // Or throw an exception indicating supplier not found
    }
}

