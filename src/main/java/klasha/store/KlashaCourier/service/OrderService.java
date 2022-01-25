package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.OrderDto;
import klasha.store.KlashaCourier.service.exception.OrderAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

      void createOrder(OrderDto orderDto) throws OrderAlreadyExistException;
}
