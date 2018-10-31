package com.welooky.mongodb.repository;

import com.welooky.mongodb.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, Integer> {
    OrderEntity findByProduct(String product);
}
