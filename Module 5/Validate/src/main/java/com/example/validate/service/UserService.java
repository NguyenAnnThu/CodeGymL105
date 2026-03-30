package com.example.validate.service;

import com.example.validate.DTO.UserDTO;
import com.example.validate.entity.User;
import com.example.validate.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserDTO dto) {
        User user= new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setAge(dto.getAge());
        user.setGmail(dto.getGmail());
        userRepository.save(user);
    }
}
