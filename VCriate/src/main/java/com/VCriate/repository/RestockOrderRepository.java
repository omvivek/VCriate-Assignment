package com.VCriate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VCriate.model.RestockOrder;

@Repository
public interface RestockOrderRepository extends JpaRepository<RestockOrder, Long> {
}

