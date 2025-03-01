package post_office.simulAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import post_office.simulAPI.dto.DeliveryType;
import post_office.simulAPI.entity.Order;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStartDeliveryFalse();
    List<Order> findByDeliveryTypeNot(DeliveryType deliveryType);

}

