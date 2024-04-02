package com.example.capstone2.Controller;

import com.example.capstone2.Api.Api;
import com.example.capstone2.Model.Orderr;
import com.example.capstone2.Model.Ticket;
import com.example.capstone2.Service.OrderService;
import com.example.capstone2.Service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    Logger logger= LoggerFactory.getLogger(OrderController.class);
    @GetMapping("/get")
    public ResponseEntity getOrder()
    {
        logger.info("inside get all order");
        return ResponseEntity.status(200).body(orderService.getSoldTicket());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        logger.info("inside delete order");
        orderService.deleteOrder(id);
        return ResponseEntity.ok().body(new Api("Order deleted"));
    }
    @PostMapping("/addOrder/{clubName1}/{clubName2}/{userId}/{noTickets}")
    public ResponseEntity addOrder(@PathVariable String clubName1, @PathVariable String clubName2, @PathVariable Integer userId, @PathVariable Integer noTickets, @RequestBody @Valid Orderr order) {

        logger.info("inside add order");
        orderService.OrderTicket(userId,noTickets, order, clubName1,clubName2);
        return ResponseEntity.ok().body(new Api("Order Made  "));
    }

}