package com.welooky.mongodb.repository;

import com.welooky.mongodb.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, Integer>, OrderDao {
    OrderEntity findByProduct(String product);

    @Query("{'customer':?0}")
    List<OrderEntity> findByCustomer(String customer);
}
