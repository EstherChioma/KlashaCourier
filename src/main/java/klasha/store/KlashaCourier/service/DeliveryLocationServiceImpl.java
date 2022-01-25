package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.DeliveryLocationDto;
import klasha.store.KlashaCourier.models.DeliveryLocation;
import klasha.store.KlashaCourier.repository.DeliveryLocationRepository;
//import klasha.store.KlashaCourier.service.DeliveryLocationService;
import klasha.store.KlashaCourier.service.exception.LocationDoestNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j

    public class DeliveryLocationServiceImpl implements DeliveryLocationService {

    @Autowired
    DeliveryLocationRepository deliveryLocationRepository;

    @Override
    public String addDeliveryLocation(DeliveryLocationDto deliveryLocationDto) {

        DeliveryLocation deliveryLocation = new DeliveryLocation();
        deliveryLocation.setFirstName(deliveryLocationDto.getFirstName());
        deliveryLocation.setLastName(deliveryLocationDto.getLastName());
        deliveryLocation.setAddress(deliveryLocationDto.getAddress());
        deliveryLocation.setEmail(deliveryLocationDto.getEmail());
        deliveryLocation.setLandmark(deliveryLocationDto.getLandmark());
        deliveryLocation.setPhoneNumber(deliveryLocationDto.getPhoneNumber());

        deliveryLocationRepository.save(deliveryLocation);
        log.info("Delivery Location created successfully --->{}" , deliveryLocation);

        return null;
    }

    @Override
    public List<DeliveryLocation> viewAllDeliveryLocation() throws LocationDoestNotExistException {
       List<DeliveryLocation> deliveryLocationList = deliveryLocationRepository.findAll();
        return deliveryLocationList;

    }


    @Override
    public String deleteLocationById(Long id) {

        DeliveryLocation deliveryLocation = deliveryLocationRepository.getById(id);
        if(deliveryLocation.equals(id)){
            deliveryLocationRepository.delete(deliveryLocation);
        }
        return "delete successfully";

    }

    @Override
    public String deleteAllLocations(DeliveryLocationDto deliveryLocationDto) {
        deliveryLocationRepository.deleteAll();
        return "All delivery locations deleted successfully";
    }

    @Override
    public DeliveryLocation updateLocationById(DeliveryLocationDto deliveryLocationDto, Long id) {


        if (deliveryLocationRepository.findById(id).isPresent()) {

            DeliveryLocation deliveryLocation = deliveryLocationRepository.getById(id);
            deliveryLocation.setFirstName(deliveryLocationDto.getFirstName());
            deliveryLocation.setLastName(deliveryLocationDto.getLastName());
            deliveryLocation.setAddress(deliveryLocationDto.getAddress());
            deliveryLocation.setPhoneNumber(deliveryLocationDto.getPhoneNumber());
            deliveryLocation.setEmail(deliveryLocationDto.getEmail());
            deliveryLocation.setLandmark(deliveryLocationDto.getLandmark());

            deliveryLocationRepository.save(deliveryLocation);

        }

        log.info("delivery location updated successfully");
        return null;
    }



}
