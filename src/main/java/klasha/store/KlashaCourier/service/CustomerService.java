package klasha.store.KlashaCourier.service;


import klasha.store.KlashaCourier.models.Customer;
import klasha.store.KlashaCourier.models.Order;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    void create_account(Customer registrationDto) throws CustomerAlreadyExistException;


    void placeOrder (Order order);
    Customer getLoggedInUser();

//    public Customer getLoggedInUser();

    // create order

}
