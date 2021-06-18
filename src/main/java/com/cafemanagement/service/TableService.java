package com.cafemanagement.service;

import com.cafemanagement.model.Table;

import java.util.List;

public interface TableService {

    void addTable(Table table);

    List<Table> getTablesByUserId(long id);

    List<Table> getList();

}
