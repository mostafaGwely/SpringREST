package com.mostafatarek.mobileappws.ui.controller;

import com.mostafatarek.mobileappws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping()
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "size") int size,
                          @RequestParam(value = "sort", defaultValue = "desc") int sort) {
        return "get user was called and the page : " + page + ", size : " + size;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getUser(@PathVariable String userId) {
        UserRest returnedValue = new UserRest();
        returnedValue.setEmail("email1.com");
        returnedValue.setFirstName("mostafa");
        returnedValue.setLastName("tarek");
        return new ResponseEntity(returnedValue, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
