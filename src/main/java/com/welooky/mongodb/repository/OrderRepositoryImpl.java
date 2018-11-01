package com.welooky.mongodb.repository;

import com.mongodb.client.result.UpdateResult;
import com.welooky.mongodb.entity.OrderEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderDao {
    @Resource
    private
    MongoTemplate mongoTemplate;

    @Override
    public long updateOrder(String product, Double price) {
        Query query = new Query(Criteria.where("product").is(product));
        Update update = new Update();
        update.set("price", price);
        UpdateResult result = mongoTemplate.updateFirst(query, update, OrderEntity.class);
        return result.getModifiedCount();
    }

    @Override
    public List<OrderEntity> queryOrderByCustomerAndProduct(String customer, String product) {
        return mongoTemplate.find(
                Query.query(
                        Criteria.where("customer").is(customer).and("product").is(product)
                ),
                OrderEntity.class);
    }


}
