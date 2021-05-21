package ua.com.rostyslav_naida.snackvendingmachine.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class VendingMachine {
   private int id;
   private String name;
   private List<Product> productList;

}
