package org.example.ecommerceproject.service.impl;

import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.model.UserPrincipal;
import org.example.ecommerceproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        return new UserPrincipal(user);
    }
}
