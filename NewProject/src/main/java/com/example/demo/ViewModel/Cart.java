package com.example.demo.ViewModel;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cart {
    List<Item> items;
}
