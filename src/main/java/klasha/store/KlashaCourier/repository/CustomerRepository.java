package klasha.store.KlashaCourier.repository;

import klasha.store.KlashaCourier.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    List<Customer> findByDateCreated(LocalDate date);

}
