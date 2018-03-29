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
    private static int max_id = 0;

    //Get all users to the list
    @CrossOrigin
    @RequestMapping(value = "/linq", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Post a user to the list
    @CrossOrigin
    @RequestMapping(value = "/linq", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            user.setId(++max_id);
            users.add(user);
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Update an user
    @CrossOrigin
    @RequestMapping(value = "/linq/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> addUser(@PathVariable("id") int id, @RequestBody User user) {
        try {
            if(users.remove(getUserById(id))) users.add(user);
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Remove a user to the list
    @CrossOrigin
    @RequestMapping(value = "/linq/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        try {
            users.remove(getUserById(id));
            return new ResponseEntity<>(users.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //Find the user who has the given id
    private User getUserById(int id){
        for(User u : users){
            if(u.getId()==id) return u;
        }
        return null;
    }
}
