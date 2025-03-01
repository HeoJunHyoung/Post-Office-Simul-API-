package post_office.simulAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import post_office.simulAPI.dto.DeliveryType;
import post_office.simulAPI.dto.OrderDto;
import post_office.simulAPI.entity.Order;
import post_office.simulAPI.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrderService {
    public static final int DELIVERY_PROBABILITY = 2;

    @Autowired
    public OrderService(OrderRepository orderRepository, Random random) {
        this.orderRepository = orderRepository;
        this.random = random;
    }

    private final OrderRepository orderRepository;
    private final Random random;

    public void saveItem(OrderDto orderDto) {

        Order order = Order.builder()
                .itemId(orderDto.getItemId())
                .startDelivery(false)
                .deliveryType(orderDto.getDeliveryType())
                .build();

        orderRepository.save(order);
    }

    public Optional<Order> getOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }


    public List<Long> startDelivery(){
        List<Order> orders = orderRepository.findByStartDeliveryFalse();

        List<Long> orderIds =  orders.stream().map(order ->{
           if(random.nextInt(DELIVERY_PROBABILITY) == 1){
               order.setStartDelivery(true);
               return order.getItemId();
           }
           return null;
        }).filter(id -> id != null)
                .collect(Collectors.toList());

        return orderIds;
    }

    public void changeDeliveryType(){
        List<Order> orders = orderRepository.findByDeliveryTypeNot(DeliveryType.DELIVERED);
        orders.stream().forEach(order ->
        {
            if(order.getDeliveryType() == DeliveryType.PENDING_ARRIVAL){
                order.setDeliveryType(DeliveryType.DELIVERED);
            }
            else if(order.getDeliveryType() == DeliveryType.IN_TRANSIT){
                order.setDeliveryType(DeliveryType.PENDING_ARRIVAL);
            }
            else if(order.getDeliveryType() == DeliveryType.DEPARTED){
                order.setDeliveryType(DeliveryType.IN_TRANSIT);
            }
        });
    }

}
