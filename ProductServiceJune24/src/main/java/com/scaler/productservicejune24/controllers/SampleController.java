package com.scaler.productservicejune24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class will be hosting set of HTTP API's.
@RestController
@RequestMapping("/say")
public class SampleController
{
    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,@PathVariable("times") int times)
    {
        String output=" ";
        for(int i=0; i<times; i++)
        {
            output = output + "Hello" + name + "\n";
        }
        return output;
    }

    @GetMapping("/bye")
    public String sayBye()
    {
       return "Bye Everyone!";
    }
}
