package com.scaler.productservicejune24.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Product extends BaseModel
{
    private String title;
    private Double price;
    @ManyToOne
    private Category category;
}
