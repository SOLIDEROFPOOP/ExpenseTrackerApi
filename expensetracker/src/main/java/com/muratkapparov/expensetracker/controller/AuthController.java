package com.muratkapparov.expensetracker.controller;

import com.muratkapparov.expensetracker.entity.JwtResponse;
import com.muratkapparov.expensetracker.entity.LoginModel;
import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.entity.UserModel;
import com.muratkapparov.expensetracker.security.CustomUserDetailsService;
import com.muratkapparov.expensetracker.service.UserService;
import com.muratkapparov.expensetracker.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginModel login) throws Exception{
        authenticate(login.getEmail(), login.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new ResponseEntity<JwtResponse>(new JwtResponse(token),HttpStatus.OK);
    }



    private void authenticate(String email, String password) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e){
            throw new Exception("User disabled");
        } catch (BadCredentialsException e){
            throw new Exception("Bad credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user){
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

}
