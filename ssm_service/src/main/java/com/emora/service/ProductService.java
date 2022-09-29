package com.emora.service;

import com.emora.domain.Product;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/9 18:05
 */
public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    Product findById(Integer id);

    void delOne(Integer id);

    void delMany(Integer[] ids);
}
