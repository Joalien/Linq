package org.hyperlinux.Linq.Controllers;

import org.hyperlinux.Linq.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class UserController {

    private static Set<User> users = new LinkedHashSet<User>();

    //Get all users to the list
    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Post a user to the list
    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            users.add(user);
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Update an user
    @CrossOrigin
    @RequestMapping(value = "/{pseudo}", method = RequestMethod.PUT)
    public ResponseEntity<?> addUser(@PathVariable("pseudo") String pseudo, @RequestBody User user) {
        try {
            if(users.remove(getUserByPseudo(pseudo))) users.add(user);
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Remove a user to the list
    @CrossOrigin
    @RequestMapping(value = "/{pseudo}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("pseudo") String pseudo) {
        try {
            users.remove(getUserByPseudo(pseudo));
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Find the user who has the given pseudo
    private User getUserByPseudo(String pseudo){
        for(User u : users){
            if(u.getPseudo().equals(pseudo)) return u;
        }
        return null;
    }
}
