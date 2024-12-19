package com.scaler.productservicejune24.inheritancetypes.singletable;

import com.scaler.productservicejune24.inheritancetypes.joinedtable.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "2")

public class Mentor extends User
{
    private String company;

}
