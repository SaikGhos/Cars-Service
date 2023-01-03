package CarsService.Cars.Entity;

import lombok.*;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(value = "inventory")
public class Inventory {


    @PrimaryKeyColumn(name = "Model", ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    @NotBlank
    //@CassandraType(type = CassandraType.Name.TEXT)
    @CassandraType(type = CassandraType.Name.TEXT)
    private String model;

    @NotBlank
    @Column("Maker's Name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String maker;

    @NotBlank
    @Column("In Stock")
    @CassandraType(type = CassandraType.Name.INT)
    private int count;

    @NotNull
    @Column("Manufacturing Year")
    @CassandraType(type = CassandraType.Name.INT)
    private int mfgYear;
}
