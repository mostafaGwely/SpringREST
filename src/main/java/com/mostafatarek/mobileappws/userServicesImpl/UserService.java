package com.mostafatarek.mobileappws.userServicesImpl;

import com.mostafatarek.mobileappws.shared.Utils;
import com.mostafatarek.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.mostafatarek.mobileappws.ui.model.response.UserRest;
import com.mostafatarek.mobileappws.userservices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    Map<String, UserRest> users;

    @Autowired
    Utils utils;

    public UserService(Utils utils){
        this.utils = utils;
    }


    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnedValue = new UserRest();
        returnedValue.setEmail(userDetails.getEmail());
        returnedValue.setFirstName(userDetails.getFirstName());
        returnedValue.setLastName(userDetails.getLastName());

        if (users == null) users = new HashMap<>();
        String userId = utils.generateRandomUserId();
        returnedValue.setUserId(userId);
        users.put(userId, returnedValue);

        return returnedValue;
    }
}
