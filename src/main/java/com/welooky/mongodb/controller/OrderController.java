package com.welooky.mongodb.controller;

import com.welooky.mongodb.entity.OrderEntity;
import com.welooky.mongodb.repository.OrderRepository;
import com.welooky.mongodb.support.NotFindException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Resource
    private OrderRepository orderRepository;

    @PostMapping("save/order")
    public ResponseEntity<OrderEntity> saveOrder(OrderEntity orderEntity) {
        OrderEntity entity = orderRepository.save(orderEntity);
        return ResponseEntity.ok()
                .body(entity);
    }

    @GetMapping("get")
    public OrderEntity queryOrder(Integer id) {
        Optional<OrderEntity> optionalEntity = orderRepository.findById(id);
        if (optionalEntity.isPresent()) {
            return optionalEntity.get();
        } else {
            throw new NotFindException("not find item");
        }
    }

    @PostMapping("update")
    public long updateOrder(String product, Double price) {
        return orderRepository.updateOrder(product, price);
    }

    @PostMapping("delete_all")
    public ResponseEntity deleteAll() {
        orderRepository.deleteAll();
        return ResponseEntity.ok()
                .body("删除成功");
    }

    @GetMapping("get/customer_product")
    public ResponseEntity<List<OrderEntity>> queryOrderByCustomerAndProduct(String customer, String product) {
        List<OrderEntity> entities = orderRepository.queryOrderByCustomerAndProduct(customer, product);
        return ResponseEntity.ok(entities);
    }

    @GetMapping("get/customer")
    public ResponseEntity<List<OrderEntity>> findByCustomer(String customer) {
        List<OrderEntity> entities = orderRepository.findByCustomer(customer);
        return ResponseEntity.ok(entities);
    }
}

