package com.librarymanagementsystem.controller;

import com.librarymanagementsystem.dto.UserDTO;
import com.librarymanagementsystem.model.User;
import com.librarymanagementsystem.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTO){

        User user = modelMapper.map(userDTO,User.class);

        User registerdUser = userService.saveUser(user);

        // Map registered User to UserDTO and return
        UserDTO registerdUserDTO = modelMapper.map(registerdUser, UserDTO.class);
        return ResponseEntity.ok(registerdUserDTO);

    }

    @GetMapping("/{universityId}")
    public ResponseEntity<UserDTO> getUserByUniversityId(@PathVariable Long universityId){
        Optional<User> user = userService.getUserByUniversityId(universityId);
        return user.map(u -> ResponseEntity.ok(modelMapper.map(u, UserDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        return user.map(u -> ResponseEntity.ok(modelMapper.map(u, UserDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
