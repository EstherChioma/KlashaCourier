package klasha.store.KlashaCourier.service;



import klasha.store.KlashaCourier.dto.OrderDto;
import klasha.store.KlashaCourier.models.*;
import klasha.store.KlashaCourier.repository.*;
import klasha.store.KlashaCourier.security.authfacade.AuthenticationFacade;
import klasha.store.KlashaCourier.service.exception.CustomerAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    AuthenticationFacade authenticationFacade;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    CustomerRepository customerRepository;


    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PickupLocationRepository pickupLocationRepository;

    @Autowired
    DeliveryLocationRepository deliveryLocationRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void create_account(Customer registrationDto) throws CustomerAlreadyExistException {

        log.info("Customer registration request ---> {}", registrationDto);

        if(customerRepository.findByEmail(registrationDto.getEmail()) == null){

            log.info("Customer is not registered ");

            AppUser appUser = new AppUser();
            appUser.setEmail(registrationDto.getEmail());
            appUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
            appUser.addRole(Role.CUSTOMER);
            appUser.setIsVerified(true);

            appUserRepository.save(appUser);

            log.info("App user saved ---> {}", appUser);

            registrationDto.setAppUser(appUser);
            registrationDto.setPassword(appUser.getPassword());

            log.info("Customer before saving --> {}", registrationDto);

            customerRepository.save(registrationDto);

            log.info("After saving customer details to db --->{}", registrationDto);

            //send verification token to email

        } else {
            throw new CustomerAlreadyExistException("a customer with email "+ registrationDto.getEmail() +" already exist!");
        }

    }

    @Override
    public void placeOrder(Order order) {

        log.info("delivery order request --->{}" + order);

        Customer customer = getLoggedInUser();
        log.info("logged-in customer ---> "+ customer);

        PickupLocation pickupLocation = new PickupLocation();
        pickupLocation.setFirstName(order.getPickupLocation().getFirstName());
        pickupLocation.setLastName(order.getPickupLocation().getLastName());
        pickupLocation.setAddress(order.getPickupLocation().getAddress());
        pickupLocation.setPhoneNumber(order.getPickupLocation().getPhoneNumber());
        pickupLocation.setEmail(order.getPickupLocation().getEmail());
        pickupLocation.setLandmark(order.getPickupLocation().getLandmark());

        pickupLocationRepository.save(pickupLocation);

        DeliveryLocation deliveryLocation = new DeliveryLocation();
        deliveryLocation.setFirstName(order.getDeliveryLocation().getFirstName());
        deliveryLocation.setLastName(order.getPickupLocation().getFirstName());
        deliveryLocation.setAddress(order.getPickupLocation().getAddress());
        deliveryLocation.setEmail(order.getPickupLocation().getEmail());
        deliveryLocation.setLandmark(order.getDeliveryLocation().getLandmark());
        deliveryLocation.setPhoneNumber(order.getPickupLocation().getPhoneNumber());

        deliveryLocationRepository.save(deliveryLocation);

        Order order1 = new Order();
        order.setPickupLocation(pickupLocation);
        order.setDeliveryLocation(deliveryLocation);
        order.setScheduleType(ScheduleType.RIGHTWAY);

        orderRepository.save(order1);

        log.info("saves order --->" + order1);




    }

    @Override
    public Customer getLoggedInUser() {
        return null;
    }

//    @Override
//    public Customer getLoggedInUser() {
//
//        String name = authenticationFacade.getAuthentication().getName();
//        log.info("Authentication facade --> {}", name);
//
//        return customerRepository.findByEmail(name);
//    }


}
