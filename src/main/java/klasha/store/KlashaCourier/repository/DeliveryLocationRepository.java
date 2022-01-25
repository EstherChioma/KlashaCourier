package klasha.store.KlashaCourier.repository;

import klasha.store.KlashaCourier.models.DeliveryLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryLocationRepository extends JpaRepository<DeliveryLocation, Long> {

}
