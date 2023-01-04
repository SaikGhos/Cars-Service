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
@Document(collection = "inventory")
public class Inventory {

    @Id
    @NotBlank
    private String model;
    @NotBlank
    private String maker;
    @NotBlank
    private int count;
    @NotNull
    private int mfgYear;
}
