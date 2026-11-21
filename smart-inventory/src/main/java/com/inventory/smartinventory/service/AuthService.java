
package com.inventory.smartinventory.service;

import com.inventory.smartinventory.entity.User;

public interface AuthService {

    User register(User user);

    User login(String email, String password);

}
