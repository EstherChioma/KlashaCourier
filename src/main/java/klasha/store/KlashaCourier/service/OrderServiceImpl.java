package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.OrderDto;
import klasha.store.KlashaCourier.models.*;
import klasha.store.KlashaCourier.repository.DeliveryLocationRepository;
import klasha.store.KlashaCourier.repository.OrderRepository;
import klasha.store.KlashaCourier.repository.PickupLocationRepository;
import klasha.store.KlashaCourier.security.authfacade.AuthenticationFacade;
import klasha.store.KlashaCourier.service.exception.OrderAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{


    @Autowired
    OrderRepository orderRepository;




    @Autowired
    PickupLocationRepository pickupLocationRepository;

    @Autowired
    DeliveryLocationRepository deliveryLocationRepository;

    PickupLocation pickupLocation;


    @Override
    public void createOrder(OrderDto orderDto) throws OrderAlreadyExistException {

        Order order = new Order();



    }
}






