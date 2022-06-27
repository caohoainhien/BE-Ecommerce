package com.example.backendjavaspring.controller.implement;

import com.example.backendjavaspring.model.entity.Role;
import com.example.backendjavaspring.model.entity.User;
import com.example.backendjavaspring.service.implement.RoleServiceImp;
import com.example.backendjavaspring.service.implement.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.backendjavaspring.model.Constants.ROLE_ADMIN_ID;

@RestController
public class MainController {

    @Autowired
    private UserServiceImp userService;
    @Autowired
    private RoleServiceImp roleService;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        Role role = roleService.findRoleById(ROLE_ADMIN_ID);
        userService.createUser(new User("admin@gmail.com", "Cao Hoài Nhiên", "1", "HCM", "0123456789", role));
        return ResponseEntity.ok("Welcome to Hoai Nhien Furniture!");
    }


}
