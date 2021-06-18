package com.cafemanagement.controller;

import com.cafemanagement.model.CurrentUser;
import com.cafemanagement.model.Order;
import com.cafemanagement.model.ProductInOrder;
import com.cafemanagement.model.Table;
import com.cafemanagement.service.OrderService;
import com.cafemanagement.service.ProductInOrderService;
import com.cafemanagement.service.TableService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/waiter")
public class WaiterController {

    private final TableService tableService;
    private final OrderService orderService;
    private final ProductInOrderService service;

    public WaiterController(TableService tableService, OrderService orderService, ProductInOrderService service) {
        this.tableService = tableService;
        this.orderService = orderService;
        this.service = service;
    }

    @GetMapping
    public String getTables(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        List<Table> tablesByUserId = tableService.getTablesByUserId(currentUser.getUser().getId());
        model.addAttribute("tables", tablesByUserId);
        return "waiter";
    }

    @PostMapping("/addOrder")
    public String createOrder(Order order) {
        orderService.createOrder(order);
        return "redirect:/";
    }

    @PostMapping("/addProductInOrder")
    public String createProductInOrder(ProductInOrder product) {
        service.createProductInOrder(product);
        return "redirect:/";
    }


}
