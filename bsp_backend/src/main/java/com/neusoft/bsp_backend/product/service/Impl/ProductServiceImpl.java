package com.neusoft.bsp_backend.product.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.mvoinfo.mapper.BrandMapper;
import com.neusoft.bsp_backend.product.entity.*;
import com.neusoft.bsp_backend.product.mapper.*;
import com.neusoft.bsp_backend.product.service.ProductService;
import com.neusoft.bsp_backend.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
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

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    ProductCategoryMapper productCategoryMapper;

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
    public int delete(int pk) {
        Product product = productMapper.getById(pk);
        return productMapper.delete(pk);
    }

    @Override
    public Product getById(int proid) {
        Product product = productMapper.getById(proid);
        Price price = priceMapper.getById(proid);
        PackageInfo packageInfo = packageInfoMapper.getById(proid);
        ProductDescription productDescription = productDescriptionMapper.getById(proid);
        Brand brand = brandMapper.getById(product.getBrd_id());
        ProductCategory productCategory = productCategoryMapper.getById(product.getPrc_id());
        product.setPrice(price);
        product.setPackageInfo(packageInfo);
        product.setProductDescription(productDescription);
        product.setBrand(brand);
        product.setProductCategory(productCategory);
        return product;
    }

    @Override
    public List<Product> getAllByFilter(Map<String, Object> map) {
        List<Product> products = productMapper.getAllByFilter(map);
        for (Product pro: products){
            Price price = priceMapper.getById(pro.getPro_id());
            PackageInfo packageInfo = packageInfoMapper.getById(pro.getPro_id());
            ProductDescription productDescription = productDescriptionMapper.getById(pro.getPro_id());
            Brand brand = brandMapper.getById(pro.getBrd_id());
            ProductCategory productCategory = productCategoryMapper.getById(pro.getPrc_id());
            pro.setProductDescription(productDescription);
            pro.setPackageInfo(packageInfo);
            pro.setPrice(price);
            pro.setBrand(brand);
            pro.setProductCategory(productCategory);
        }
        return products;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = productMapper.getAll();
        for (Product pro: products){
            Price price = priceMapper.getById(pro.getPro_id());
            PackageInfo packageInfo = packageInfoMapper.getById(pro.getPro_id());
            ProductDescription productDescription = productDescriptionMapper.getById(pro.getPro_id());
            Brand brand = brandMapper.getById(pro.getBrd_id());
            ProductCategory productCategory = productCategoryMapper.getById(pro.getPrc_id());
            pro.setProductDescription(productDescription);
            pro.setPackageInfo(packageInfo);
            pro.setPrice(price);
            pro.setBrand(brand);
            pro.setProductCategory(productCategory);
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
