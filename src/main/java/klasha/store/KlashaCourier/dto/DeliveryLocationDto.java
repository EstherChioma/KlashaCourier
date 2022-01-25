package klasha.store.KlashaCourier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryLocationDto {

    private String address;

    private String landmark;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

}
