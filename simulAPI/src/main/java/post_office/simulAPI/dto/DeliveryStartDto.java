package post_office.simulAPI.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DeliveryStartDto {
    List<Long> datas;
}
