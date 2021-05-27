package ua.com.rostyslav_naida.snackvendingmachine.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "date_of_sale", nullable = false)
    private LocalDate dateOfSale;

}
