package com.example.backendjavaspring.authority;

import com.example.backendjavaspring.model.entity.User;
import com.example.backendjavaspring.service.implement.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(MyUserDetailService.class);

    @Autowired
    private UserServiceImp userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserById(username);
        if(user != null){
            return new MyUserDetail(user);
        }else{
            log.debug("User not found with emailId: " + username);
            throw new UsernameNotFoundException("User not found with emailId: " + username);
        }
    }
}
