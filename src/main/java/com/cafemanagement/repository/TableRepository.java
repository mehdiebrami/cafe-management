package com.cafemanagement.repository;

import com.cafemanagement.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Long> {

    List<Table> findByUserId(long id);
}
