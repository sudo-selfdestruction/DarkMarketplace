package by.bsu.zxcola.userservice.service;

import by.bsu.zxcola.userservice.entity.User;
import by.bsu.zxcola.userservice.repository.UserRepository;
import by.bsu.zxcola.userservice.response.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public User signUp (User user) {
        User newUser = new User();
        newUser.setEmail(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);

        return newUser;
    }

    public User authenticate(User user) {
        return (User) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword())).getPrincipal();
    }

    public LoginResponse getLoginResponse(String jwtToken) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return loginResponse;
    }

}