package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
}
