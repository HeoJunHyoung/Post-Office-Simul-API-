package post_office.simulAPI.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderDto {
    public OrderDto() {
    }

    public OrderDto(Long itemId, DeliveryType deliveryType) {
        this.itemId = itemId;
        this.deliveryType = deliveryType;
    }

    Long itemId;
    DeliveryType deliveryType;
}
