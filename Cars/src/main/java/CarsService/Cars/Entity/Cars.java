package CarsService.Cars.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "cars")
public class Cars {

    @Id
    @NotNull
    private int engineNo;
    @NotBlank
    private String maker;
    @NotBlank
    private String model;
    @NotBlank
    private int mfgYear;
}
