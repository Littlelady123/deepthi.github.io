package com.scaler.productservicejune24.inheritancetypes.singletable;


import com.scaler.productservicejune24.inheritancetypes.joinedtable.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3")
public class Instructor extends User
{
    private String subject;

}
