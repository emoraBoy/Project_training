package com.emora.controller;

import com.emora.domain.Orders;
import com.emora.domain.Product;
import com.emora.service.OrderService;
import com.emora.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 10:49
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(currPage, pageSize);
        List<Orders> ordersList = orderService.findAll();
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList,5);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }

    @GetMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("order-add");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Orders orders){
        orderService.save(orders);
        return "redirect:/orders/findAll";
    }
}
