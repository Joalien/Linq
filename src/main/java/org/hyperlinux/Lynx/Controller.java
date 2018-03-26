package org.hyperlinux.Lynx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Controller {


    // -------------------Retrieve All Pizzas---------------------------------------------

    @RequestMapping("/")
    public ResponseEntity<?> createOrder() {
        try {
            return new ResponseEntity<>("Success\n", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error\n", HttpStatus.BAD_REQUEST);
        }
    }
}
