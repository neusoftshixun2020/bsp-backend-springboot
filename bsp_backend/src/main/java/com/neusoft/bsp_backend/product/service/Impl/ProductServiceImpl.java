package com.neusoft.bsp_backend.product.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.product.entity.PackageInfo;
import com.neusoft.bsp_backend.product.entity.Price;
import com.neusoft.bsp_backend.product.entity.Product;
import com.neusoft.bsp_backend.product.entity.ProductDescription;
import com.neusoft.bsp_backend.product.mapper.PackageInfoMapper;
import com.neusoft.bsp_backend.product.mapper.PriceMapper;
import com.neusoft.bsp_backend.product.mapper.ProductDescriptionMapper;
import com.neusoft.bsp_backend.product.mapper.ProductMapper;
import com.neusoft.bsp_backend.product.service.ProductService;
import com.neusoft.bsp_backend.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    PriceMapper priceMapper;

    @Autowired
    PackageInfoMapper packageInfoMapper;

    @Autowired
    ProductDescriptionMapper productDescriptionMapper;

    @Override
    public int insert(Product product) {
        int p = productMapper.insert(product);
        product.getPrice().setPro_id(product.getPro_id());
        int p1 = priceMapper.insert(product.getPrice());
        product.getPackageInfo().setPro_id(product.getPro_id());
        int p2 = packageInfoMapper.insert(product.getPackageInfo());
        product.getProductDescription().setPro_id(product.getPro_id());
        int p3 = productDescriptionMapper.insert(product.getProductDescription());
        return p+p1+p2+p3;
    }

    @Override
    public int update(Product product) {
        int r = productMapper.update(product);
        int r1 = priceMapper.update(product.getPrice());
        int r2 = packageInfoMapper.update(product.getPackageInfo());
        int r3 = productDescriptionMapper.update(product.getProductDescription());
        return r+r1+r2+r3;
    }

    @Override
    public int delete(String pk) {
        Product product = productMapper.getById(pk);
        int d = priceMapper.delete(String.valueOf(product.getPrice().getOfp_id()));
        int d1 = packageInfoMapper.delete(String.valueOf(product.getPackageInfo().getPck_id()));
        int d2 = productDescriptionMapper.delete(String.valueOf(product.getProductDescription().getPdn_id()));
        int d3 = productMapper.delete(pk);
        return d+d1+d2+d3;
    }

    @Override
    public Product getById(String proid) {
        Price price = priceMapper.getById(proid);
        PackageInfo packageInfo = packageInfoMapper.getById(proid);
        ProductDescription productDescription = productDescriptionMapper.getById(proid);
        Product product = productMapper.getById(proid);
        product.setPrice(price);
        product.setPackageInfo(packageInfo);
        product.setProductDescription(productDescription);
        return product;
    }

    @Override
    public List<Product> getAllByFilter(Map<String, Object> map) {
        List<Product> products = productMapper.getAllByFilter(map);
        for (Product pro: products){
            Price price = priceMapper.getById(String.valueOf(pro.getPro_id()));
            PackageInfo packageInfo = packageInfoMapper.getById(String.valueOf(pro.getPro_id()));
            ProductDescription productDescription = productDescriptionMapper.getById(String.valueOf(pro.getPro_id()));
            pro.setProductDescription(productDescription);
            pro.setPackageInfo(packageInfo);
            pro.setPrice(price);
        }
        return products;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = productMapper.getAll();
        for (Product pro: products){
            Price price = priceMapper.getById(String.valueOf(pro.getPro_id()));
            PackageInfo packageInfo = packageInfoMapper.getById(String.valueOf(pro.getPro_id()));
            ProductDescription productDescription = productDescriptionMapper.getById(String.valueOf(pro.getPro_id()));
            pro.setProductDescription(productDescription);
            pro.setPackageInfo(packageInfo);
            pro.setPrice(price);
        }
        return products;
    }

    @Override
    public PageInfo<Product> getAll(Integer pageNum, Integer pagesize) {
        return this.getAllByFilter(pageNum, pagesize, new HashMap<>());
    }

    @Override
    public PageInfo<Product> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map) {
        PageHelper.startPage(pageNum, pagesize, true);
        List<Product> products = this.getAllByFilter(map);
        return new PageInfo<>(products);
    }
}
