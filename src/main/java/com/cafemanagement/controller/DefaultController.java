package com.cafemanagement.controller;

import com.cafemanagement.model.CafeManagementUserDetails;
import com.cafemanagement.model.UserType;
import com.cafemanagement.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    private final WaiterService waiterService;
    private final TableService tableService;
    private final ProductService productService;

    public DefaultController(WaiterService waiterService, TableService tableService,   ProductService productService) {
        this.waiterService = waiterService;
        this.tableService = tableService;
         this.productService = productService;
    }

    @GetMapping("/")
    public String getDefault(@AuthenticationPrincipal CafeManagementUserDetails cafeManagementUserDetails, Model model) {
        model.addAttribute("user", cafeManagementUserDetails);
        model.addAttribute("products", productService.getList());
        if (cafeManagementUserDetails.getUser().getUserType().equals(UserType.WAITER)) {
             model.addAttribute("tables", tableService.getTablesByUserId(cafeManagementUserDetails.getUser().getId()));
        } else {
            model.addAttribute("waiters", waiterService.getList());
            model.addAttribute("tables", tableService.getList());
         }
        return "index";
    }


}
