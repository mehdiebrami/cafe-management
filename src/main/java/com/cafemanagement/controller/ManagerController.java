package com.cafemanagement.controller;

import com.cafemanagement.model.Product;
import com.cafemanagement.model.Table;
import com.cafemanagement.model.User;
import com.cafemanagement.service.ProductService;
import com.cafemanagement.service.TableService;
import com.cafemanagement.service.WaiterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @PostMapping("/addTable")
    public String addTable(Table table) {
        tableService.addTable(table);
        return "redirect:/";
    }

    @PostMapping("/addWaiter")
    public String addWaiter(@Valid User user, BindingResult result, Model model) {
          waiterService.addWaiter(user);
        return "redirect:/";
    }


}
