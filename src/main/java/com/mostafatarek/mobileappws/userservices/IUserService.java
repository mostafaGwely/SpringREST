package com.mostafatarek.mobileappws.userservices;

import com.mostafatarek.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.mostafatarek.mobileappws.ui.model.response.UserRest;

public interface IUserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
