package klasha.store.KlashaCourier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PickupLocationDto {


    private String  state;

    private  String city;

    private String address;

    private String destination;

    private String origin;
}
