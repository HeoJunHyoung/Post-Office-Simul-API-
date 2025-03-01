package post_office.simulAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import post_office.simulAPI.dto.DeliveryStartDto;
import post_office.simulAPI.dto.OrderDto;
import post_office.simulAPI.service.OrderService;

import java.util.List;

@RestController
public class OrderContorller {

    @Autowired
    public OrderContorller(OrderService orderService, RestTemplate restTemplate) {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
    }
    private final OrderService orderService;
    private final RestTemplate restTemplate;


    @GetMapping("/saveItem")
    public void saveItem(OrderDto orderDto){

        orderService.saveItem(orderDto);
    }

    @Scheduled(fixedRate = 600000)
    public String startDelivery(){
//        String url = "http://localhost:8080/test";
//
//        List<Long> datas =  orderService.startDelivery();
//
//        // 요청 본문 (예시로 JSON 형식의 객체를 보낸다고 가정)
//        DeliveryStartDto requestBody = DeliveryStartDto.builder()
//                .datas(datas)
//                .build();
//
//        // POST 요청 보내기
//        String response = restTemplate.postForObject(url, requestBody, String.class);
//
//        // 응답 처리
//        return response;
    }
}
