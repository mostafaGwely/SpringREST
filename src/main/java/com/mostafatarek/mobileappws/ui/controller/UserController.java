package com.mostafatarek.mobileappws.ui.controller;

import com.mostafatarek.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.mostafatarek.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.mostafatarek.mobileappws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {
    Map<String, UserRest> users;

    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size") int size,
                          @RequestParam(value = "sort", defaultValue = "desc") int sort) {
        return "get user was called and the page : " + page + ", size : " + size;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getUser(@PathVariable String userId) {
        if (users.containsKey(userId))
            return new ResponseEntity(users.get(userId), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NO_CONTENT);

    }


    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnedValue = new UserRest();
        returnedValue.setEmail(userDetails.getEmail());
        returnedValue.setFirstName(userDetails.getFirstName());
        returnedValue.setLastName(userDetails.getLastName());

        if (users == null) users = new HashMap<>();
        String userId = UUID.randomUUID().toString();
        returnedValue.setUserId(userId);
        users.put(userId, returnedValue);

        return new ResponseEntity(returnedValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);
        
        return new ResponseEntity(storedUserDetails, HttpStatus.OK);
    }


    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
