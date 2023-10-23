package com.example.runapp.service;

import com.example.runapp.dto.UserDto;
import com.example.runapp.model.Users;
import com.example.runapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<Users> createUsers(UserDto userDto){
        Users newUser = new Users();
        newUser .setFirstName(userDto.getFirstName());
        newUser .setLastName(userDto.getLastName());
        newUser .setUsername(userDto.getUsername());
        newUser .setEmail(userDto.getEmail());
        newUser .setPassword(userDto.getPassword());

        Users savedUser = userRepository.save(newUser);
        return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void getUser(Long id){
        userRepository.findAllById(Collections.singleton(id));
    }

    public ResponseEntity<Users> updateUser(UserDto edit,Long id){
//        Users updatingUser = Users.builder()
//                .firstName(edit.getFirstName())
//                .lastName(edit.getLastName())
//                .username(edit.getUsername())
//                .email(edit.getEmail())
//                .password(edit.getPassword())
//                .build();
//
//          Users updatedUsers = userRepository.save(updatingUser);
//           return  new ResponseEntity<>(updatedUsers,HttpStatus.CREATED);
                Users updatingUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found, check the User details"));
                updatingUser.setFirstName(edit.getFirstName());
                updatingUser.setLastName(edit.getLastName());
                updatingUser.setUsername(edit.getUsername());
                updatingUser.setEmail(edit.getEmail());
                updatingUser.setPassword(edit.getPassword());
              Users updatedUser = userRepository.save(updatingUser);
              return  new ResponseEntity<>(updatedUser,HttpStatus.CREATED);

    }
}
