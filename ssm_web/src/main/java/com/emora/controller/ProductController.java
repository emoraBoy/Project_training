package com.emora.controller;

import com.emora.domain.Product;
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
 * @Date 2022/9/9 17:54
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    /**
     * @throws
     * @Title: findAll
     * @Description: 查询所有
     * @param:
     * @return:
     * @date: 2022/9/9 18:03
     */
    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        PageHelper.startPage(currPage, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        PageInfo<Product> pageInfo = new PageInfo<>(productList,5);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * @throws
     * @Title: save
     * @Description: 新增产品
     * @param: product
     * @return: string
     * @date: 2022/9/9 20:29
     */
    @PostMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product/findAll";
    }


    @GetMapping("/updateById")
    public ModelAndView updateById(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product-update");
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product/findAll";
    }

    @GetMapping("/delOne")
    public String delOne(Integer id) {
        productService.delOne(id);
        return "redirect:/product/findAll";
    }

    @PostMapping("/delMany")
    public String delMany(Integer[] ids) {
        productService.delMany(ids);
        return "redirect:/product/findAll";
    }

}
