package com.cafemanagement.service;


import com.cafemanagement.model.User;

import java.util.List;

public interface WaiterService {

    void createWaiter(User user);

    List<User> getALl();

}
