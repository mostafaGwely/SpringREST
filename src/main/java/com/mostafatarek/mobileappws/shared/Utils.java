package com.mostafatarek.mobileappws.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generateRandomUserId(){
        return  UUID.randomUUID().toString();
    }
}
