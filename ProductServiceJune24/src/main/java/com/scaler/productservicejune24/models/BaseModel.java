package com.scaler.productservicejune24.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseModel
{

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
    private Long id;
    private Date CreatedAt;
    private Date UpdatedAt;
}
