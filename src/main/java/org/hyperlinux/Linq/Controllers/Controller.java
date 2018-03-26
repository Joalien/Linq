package org.hyperlinux.Linq.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @RequestMapping("/")
    public ResponseEntity<?> createOrder() {
        try {
            return new ResponseEntity<>("Test production\n", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error\n", HttpStatus.BAD_REQUEST);
        }
    }
}
