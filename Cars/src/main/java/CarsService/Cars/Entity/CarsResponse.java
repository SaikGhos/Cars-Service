package CarsService.Cars.Entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarsResponse {

    private int engineNo;
    private String maker;
    private String model;
    private int mfgYear;
    private String status;
}
