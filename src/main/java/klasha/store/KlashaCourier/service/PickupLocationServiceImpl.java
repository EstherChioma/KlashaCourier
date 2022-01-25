package klasha.store.KlashaCourier.service;

import klasha.store.KlashaCourier.dto.PickupLocationDto;
import klasha.store.KlashaCourier.service.exception.LocationDoestNotExistException;

import java.util.List;

public class PickupLocationServiceImpl implements PickupLocationService {
    @Override
    public void addLocation(PickupLocationDto pickupLocationDto) throws LocationDoestNotExistException {

    }

    @Override
    public String removeLocationById(Long id) {
        return null;
    }

    @Override
    public String removeAllLocations(PickupLocationDto pickupLocationDto) {
        return null;
    }

    @Override
    public List<PickupLocationDto> viewAllLocations() {
        return null;
    }

    @Override
    public String updateLocation(PickupLocationDto pickupLocationDto) {
        return null;
    }
}
