package uz.Koica.Hotels.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class TourReq {
    private Long id;
    private int ticketCount;
    private String name;
    private String description;
    private String hashCode;
    private Long typeId;
    private Double price;
    private Boolean isActual;
}
