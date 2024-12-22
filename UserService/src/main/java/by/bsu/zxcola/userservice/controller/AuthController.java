package by.bsu.zxcola.userservice.controller;


import by.bsu.zxcola.userservice.service.AuthenticationService;
import by.bsu.zxcola.userservice.service.JwtService;
import by.bsu.zxcola.userservice.dto.UserDto;
import by.bsu.zxcola.userservice.entity.User;
import by.bsu.zxcola.userservice.mapper.UserMapper;
import by.bsu.zxcola.userservice.response.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody UserDto userDto) {
        System.out.println(userMapper.convertUserDtoToUser(userDto).getPassword() + userMapper.convertUserDtoToUser(userDto).getEmail());
        User registeredUser = authenticationService.signUp(userMapper.convertUserDtoToUser(userDto));
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserDto userDto) {
        User authenticatedUser = authenticationService.authenticate(userMapper.convertUserDtoToUser(userDto));
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = authenticationService.getLoginResponse(jwtToken);
        return ResponseEntity.ok(loginResponse);
    }
}
