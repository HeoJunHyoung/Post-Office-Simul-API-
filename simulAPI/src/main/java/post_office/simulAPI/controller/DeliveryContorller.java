package post_office.simulAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import post_office.simulAPI.dto.DeliveryStartDto;
import post_office.simulAPI.dto.OrderDto;
import post_office.simulAPI.entity.Order;
import post_office.simulAPI.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
public class DeliveryContorller {

    private final OrderService orderService;

    @Autowired
    public DeliveryContorller(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getDeliveryState")
    public OrderDto getDeliverState(Long orderId){
        Optional<Order> OptionalOrder = orderService.getOrder(orderId);
        if (OptionalOrder.isPresent()){
            Order order = OptionalOrder.get();
            return OrderDto.builder()
                    .deliveryType(order.getDeliveryType())
                    .itemId(orderId)
                    .build();
        }
        return null;
    }

//    5분마다 실행하여 deliveryType을 한단계 진행시킨다.
    @Scheduled(fixedRate = 300000)
    public void changeDeliveryType(){

        orderService.changeDeliveryType();
    }

}
