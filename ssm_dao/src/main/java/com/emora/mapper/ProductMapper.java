package com.emora.mapper;

import com.emora.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/9 18:14
 */
@Repository
public interface ProductMapper {
    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    Product findById(Integer id);

    void delOne(Integer id);
}
