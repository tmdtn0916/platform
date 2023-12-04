package com.mnu.platform.service;

import com.mnu.platform.entity.UserData;
import com.mnu.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public UserData findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
