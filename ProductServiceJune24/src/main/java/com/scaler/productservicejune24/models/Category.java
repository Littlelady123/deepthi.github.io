package com.scaler.productservicejune24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category extends  BaseModel{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Product> products;
}



