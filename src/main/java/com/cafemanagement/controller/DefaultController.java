package com.cafemanagement.controller;

import com.cafemanagement.model.User;
import com.cafemanagement.model.UserType;
import com.cafemanagement.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    private final WaiterService waiterService;
    private final ProductService productService;
    private final TableService tableService;
    private final OrderService orderService;
    private final UserService userService;

    public DefaultController(WaiterService waiterService, TableService tableService, OrderService orderService, ProductService productService, UserService userService) {
        this.waiterService = waiterService;
        this.tableService = tableService;
        this.orderService = orderService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getDefault(Authentication principal, Model model) {
        model.addAttribute("user", principal.getName());
        model.addAttribute("products", productService.getAll());
        User user = userService.getUser(principal.getName());
        if (user.getUserType().equals(UserType.WAITER)) {
            model.addAttribute("waiterOrders", orderService.getWaiterOrder(user.getId()));
            model.addAttribute("tables", tableService.getTablesByUserId(user.getId()));
        } else {
            model.addAttribute("waiters", waiterService.getALl());
            model.addAttribute("tables", tableService.getAllTables());
            model.addAttribute("orders", orderService.getList());
        }
        return "index";
    }


}
