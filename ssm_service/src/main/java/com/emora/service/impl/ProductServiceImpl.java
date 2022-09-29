package com.emora.service.impl;

import com.emora.domain.Product;
import com.emora.mapper.ProductMapper;
import com.emora.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/9 18:11
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        List<Product> productList = productMapper.findAll();
        return productList;
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }

    @Override
    public void delOne(Integer id) {
        productMapper.delOne(id);
    }

    @Override
    public void delMany(Integer[] ids) {
        if (ids != null) {
            for (Integer id : ids) {
                productMapper.delOne(id);
            }
        }
    }
}
