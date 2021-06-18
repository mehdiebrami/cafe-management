package com.cafemanagement.service;


import com.cafemanagement.model.User;

import java.util.List;

public interface WaiterService {

    void addWaiter(User user);

    List<User> getList();

}
