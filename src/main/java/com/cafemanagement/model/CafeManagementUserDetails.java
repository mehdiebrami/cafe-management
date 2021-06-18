package com.cafemanagement.model;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
public class CafeManagementUserDetails extends User {


    private com.cafemanagement.model.User user;

    public CafeManagementUserDetails(com.cafemanagement.model.User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }
}
