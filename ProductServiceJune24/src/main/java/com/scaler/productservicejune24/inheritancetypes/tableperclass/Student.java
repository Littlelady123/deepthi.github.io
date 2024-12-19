package com.scaler.productservicejune24.inheritancetypes.tableperclass;


import com.scaler.productservicejune24.inheritancetypes.joinedtable.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_students")

public class Student extends User
{
    private String batch;
}
