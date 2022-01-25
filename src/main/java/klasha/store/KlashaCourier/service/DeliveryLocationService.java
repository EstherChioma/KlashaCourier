package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.DeliveryLocationDto;
import klasha.store.KlashaCourier.models.DeliveryLocation;
import klasha.store.KlashaCourier.service.exception.LocationDoestNotExistException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public interface DeliveryLocationService {

    String addDeliveryLocation(DeliveryLocationDto deliveryLocationDto);

    List<DeliveryLocation> viewAllDeliveryLocation() throws LocationDoestNotExistException;

    String deleteLocationById(Long id);

    String deleteAllLocations(DeliveryLocationDto deliveryLocationDto);

    DeliveryLocation updateLocationById(DeliveryLocationDto  deliveryLocationDto, Long id);


}
