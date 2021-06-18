package com.cafemanagement.service.impl;

import com.cafemanagement.model.User;
import com.cafemanagement.model.UserType;
import com.cafemanagement.repository.UserRepository;
import com.cafemanagement.service.WaiterService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterServiceImpl implements WaiterService {

    private final UserRepository userRepository;

    public WaiterServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createWaiter(User user) {
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encode);
        user.setUserType(UserType.WAITER);
        userRepository.save(user);
    }

    @Override
    public List<User> getALl() {
        List<User> userByUserType = userRepository.getUserByUserType(UserType.WAITER);
        return userByUserType;
    }
}
