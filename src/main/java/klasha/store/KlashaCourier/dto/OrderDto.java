package klasha.store.KlashaCourier.dto;

import klasha.store.KlashaCourier.models.DeliveryLocation;
import klasha.store.KlashaCourier.models.PickupLocation;
import klasha.store.KlashaCourier.models.ScheduleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderDto {

        private PickupLocation pickupLocation;

        private DeliveryLocation deliveryLocation;

        private String  scheduleType;

}
