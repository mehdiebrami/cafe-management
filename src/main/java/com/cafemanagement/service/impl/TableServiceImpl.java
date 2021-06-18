package com.cafemanagement.service.impl;

import com.cafemanagement.model.Table;
import com.cafemanagement.repository.TableRepository;
import com.cafemanagement.service.TableService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {

    private final TableRepository tableRepository;

    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public void addTable(Table table) {
        tableRepository.save(table);
    }

    @Override
    public List<Table> getTablesByUserId(long id) {
        return tableRepository.findByUserId(id);
    }

    @Override
    public List<Table> getList() {
        return tableRepository.findAll();
    }
}
