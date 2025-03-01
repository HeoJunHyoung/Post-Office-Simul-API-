package post_office.simulAPI.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import post_office.simulAPI.dto.DeliveryType;

@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {

    public Order() {
    }

    public Order(Long itemId, Boolean startDelivery, DeliveryType deliveryType) {
        this.itemId = itemId;
        this.startDelivery = startDelivery;
        this.deliveryType = deliveryType;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long itemId;
    Boolean startDelivery;
    DeliveryType deliveryType;

}
