package ua.com.rostyslav_naida.snackvendingmachine.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "vending_machine")
public class VendingMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}",
            message = "Must be minimum 6 characters, at least one letter and one number")
    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "location", nullable = false)
    private String location;

    @OneToMany(mappedBy = "vendingMachine")
    private List<Product> productList;

}
