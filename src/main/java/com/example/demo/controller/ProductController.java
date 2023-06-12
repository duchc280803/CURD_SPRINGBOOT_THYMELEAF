package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("productList",productList);
        return "view/product";
    }

    @GetMapping("view-create")
    public String viewCreate(){
        return "view/create";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "view/update";
    }

    @PostMapping("update")
    public String update( @ModelAttribute("product") Product product, Model model, BindingResult result){
        if (result.hasErrors()){
            return "view/update";
        }
        List<Product> productList = productService.getAll();
        model.addAttribute("productList",productList);
        productService.update(product);
        return "redirect:/product/hien-thi";
    }

    @PostMapping("create")
    public String create(@ModelAttribute("product") Product product, Model model, BindingResult result){
        if (result.hasErrors()){
            return "view/create";
        }
        List<Product> productList = productService.getAll();
        model.addAttribute("productList",productList);
        productService.create(product);
        return "redirect:/product/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id,Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("productList",productList);
        productService.delete(id);
        return "view/product";
    }
}
