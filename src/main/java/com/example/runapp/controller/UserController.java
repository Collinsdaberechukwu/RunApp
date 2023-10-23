package com.example.runapp.controller;

import com.example.runapp.dto.UserDto;
import com.example.runapp.model.Users;
import com.example.runapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/post")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        userService.createUsers(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/getUser/{id}")
    public  void getUser(@PathVariable Long id){
        userService.getUser(id);
    }
    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto updateUsers, @PathVariable Long id){
        userService.updateUser(updateUsers, id);
        return new ResponseEntity<>(updateUsers,HttpStatus.CREATED);
    }
}
