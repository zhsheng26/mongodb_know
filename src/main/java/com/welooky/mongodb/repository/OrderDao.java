package com.welooky.mongodb.repository;

import com.welooky.mongodb.entity.OrderEntity;

import java.util.List;

public interface OrderDao {
    long updateOrder(String product, Double price);

    List<OrderEntity> queryOrderByCustomerAndProduct(String customer, String product);




}
