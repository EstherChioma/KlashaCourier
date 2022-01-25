package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.PickupLocationDto;
import klasha.store.KlashaCourier.service.exception.LocationDoestNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PickupLocationService {

    void addLocation(PickupLocationDto pickupLocationDto) throws LocationDoestNotExistException;
    String removeLocationById(Long id);
    String removeAllLocations(PickupLocationDto pickupLocationDto);
    List<PickupLocationDto> viewAllLocations();
    String updateLocation(PickupLocationDto pickupLocationDto);



}
