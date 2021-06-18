package com.cafemanagement.model;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    @Getter
    private com.cafemanagement.model.User user;

    public CurrentUser(com.cafemanagement.model.User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }
}
