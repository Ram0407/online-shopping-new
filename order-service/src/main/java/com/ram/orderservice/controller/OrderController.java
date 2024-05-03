package com.ram.orderservice.controller;

import com.ram.orderservice.dto.OrderRequest;
import com.ram.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "myFallBackMethod")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully...!";
    }

    public String myFallBackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return "Oops! We regret to inform that something went wrong, Please order after sometime";
    }

}
