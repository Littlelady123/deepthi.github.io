package com.scaler.productservicejune24.exceptions;

public class ProductNotFoundException extends RuntimeException
{
    public ProductNotFoundException(String message)
    {
        super(message);
    }

}
