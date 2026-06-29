package com.ecommerce.user.controller;

import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
   private UserService userService;
    private static Logger logger= LoggerFactory.getLogger(UserController.class);

    //@GetMapping("/api/users")
    @RequestMapping(value = "/api/users" , method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        logger.info("Request recied for user :{}"+id);
        logger.trace("this is very details");
        logger.debug("this used for development debugging");
        logger.info("this is for general system info");
        logger.warn("this is for warning");
        logger.error("this is for error");
        UserResponse userResponse=userService.fetchUser(id).orElseThrow();
        if(userResponse==null){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(userResponse, HttpStatus.OK);

    }

    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return ResponseEntity.ok("user Added");
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id,@RequestBody UserRequest userRequest){
        boolean updated= userService.updateUser(id,userRequest);
        if(updated)
            return ResponseEntity.ok("user updated successfully");
        return ResponseEntity.notFound().build();
    }

}
