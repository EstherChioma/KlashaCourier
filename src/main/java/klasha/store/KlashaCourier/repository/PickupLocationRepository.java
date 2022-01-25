package klasha.store.KlashaCourier.repository;

import klasha.store.KlashaCourier.models.PickupLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupLocationRepository extends JpaRepository<PickupLocation, Long> {
}
