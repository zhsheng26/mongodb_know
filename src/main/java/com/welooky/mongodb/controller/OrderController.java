package com.welooky.mongodb.controller;

import com.welooky.mongodb.entity.OrderEntity;
import com.welooky.mongodb.repository.DomainRepositoryImpl;
import com.welooky.mongodb.repository.OrderRepository;
import com.welooky.mongodb.support.NotFindException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
public class OrderController {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private DomainRepositoryImpl domainRepository;

    @PostMapping("save/order")
    public String saveOrder(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
        return "success";
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
        return domainRepository.updateOrder(product, price);
    }
}
