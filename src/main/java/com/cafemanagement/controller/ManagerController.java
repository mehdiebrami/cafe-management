package com.cafemanagement.controller;

import com.cafemanagement.model.Product;
import com.cafemanagement.model.Table;
import com.cafemanagement.model.User;
import com.cafemanagement.service.ProductService;
import com.cafemanagement.service.TableService;
import com.cafemanagement.service.WaiterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {

    private final WaiterService waiterService;
    private final TableService tableService;
    private final ProductService productService;

    public ManagerController(WaiterService waiterService, TableService tableService, ProductService productService) {
        this.waiterService = waiterService;
        this.tableService = tableService;
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public String createProduct(Product product) {
        productService.createProduct(product);
        return "redirect:/";
    }

    @PostMapping("/addTable")
    public String createTable(Table table, Model model) {
        tableService.createTable(table);
        return "redirect:/";
    }

    @PostMapping("/addWaiter")
    public String createWaiter(User user) {
        waiterService.createWaiter(user);
        return "redirect:/";
    }


}
