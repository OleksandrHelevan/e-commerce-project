package org.example.ecommerceproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ecommerceproject.dto.UserDTO;
import org.example.ecommerceproject.exception.NoAuthenticatedTokenException;
import org.example.ecommerceproject.exception.NoSuchObjectException;
import org.example.ecommerceproject.mapper.UserMapper;
import org.example.ecommerceproject.model.User;
import org.example.ecommerceproject.repository.UserRepository;
import org.example.ecommerceproject.request.AuthenticationRequest;
import org.example.ecommerceproject.request.RegistrationRequest;
import org.example.ecommerceproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtServiceImpl jwtServiceImpl;

    @Override
    public RegistrationRequest register(RegistrationRequest request) {
        User user = UserMapper.fromRequestToClient(request);
        return new RegistrationRequest(userRepository.save(user));
    }

    @Override
    public String verify(AuthenticationRequest request) throws NoAuthenticatedTokenException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        if (authentication.isAuthenticated())
            return jwtServiceImpl.generateToken(request.username());
        else throw new NoAuthenticatedTokenException("No registered user found");
    }

    @Override
    public List<User> getAllUsers() { //TEMP
        return userRepository.findAll();
    }

    @Override
    public UserDTO getUserByUsername(String username) throws NoSuchObjectException {
        User user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new NoSuchObjectException("User with such name not found"));
        return UserMapper.toDTO(user);
    }
}
