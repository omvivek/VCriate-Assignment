package com.VCriate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCriate.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}

