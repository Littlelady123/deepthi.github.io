package com.scaler.productservicejune24.inheritancetypes.singletable;


import com.scaler.productservicejune24.inheritancetypes.joinedtable.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class Student extends User
{
    private String batch;
}
