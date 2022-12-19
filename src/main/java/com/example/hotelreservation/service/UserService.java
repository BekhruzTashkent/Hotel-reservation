package com.example.hotelreservation.service;


import com.example.hotelreservation.entity.Room;
import com.example.hotelreservation.entity.User;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.UserDTO;
import com.example.hotelreservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getByPasswordAndEmail(UserDTO userDTO){
        Optional<User> byPasswordAndEmail = userRepository.findByPasswordAndEmail(userDTO.getPassword(), userDTO.getEmail());
        return byPasswordAndEmail.orElse(null);
    }

    public User findById(Integer id){
        Optional<User> byId = userRepository.findById(id);
        return  byId.orElse(null);
    }

    public ApiResponse addUser(@Valid UserDTO userDTO){
        try {
            User user = new User();
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setPhone(userDTO.getPhone());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setCountry(userDTO.getCountry());
            user.setCity(userDTO.getCity());
            user.setAddress(userDTO.getAddress());
            user.setZipcode(userDTO.getZipcode());
            userRepository.save(user);
            return new ApiResponse("User added", true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ApiResponse updateUser(Integer id, UserDTO userDTO){
        try {
            Optional<User> byId = userRepository.findById(id);
            if (byId.isEmpty()) {
                return new ApiResponse("no such user", false);
            }
            User user = byId.get();
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setPhone(userDTO.getPhone());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setCountry(userDTO.getCountry());
            user.setCity(userDTO.getCity());
            user.setAddress(userDTO.getAddress());
            user.setZipcode(userDTO.getZipcode());
            userRepository.save(user);
            return new ApiResponse("User updated", true);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }

    }


    public ApiResponse deleteUser(Integer id){
        Optional<User> byId = userRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such user id", false);
        }

        userRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }

}
