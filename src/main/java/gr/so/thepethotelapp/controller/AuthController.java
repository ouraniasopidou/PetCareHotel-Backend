package gr.so.thepethotelapp.controller;

import gr.so.thepethotelapp.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> loginRequest) {
        Map<String, String> response = new HashMap<>();

        try {
            // Validate request body
            if (!loginRequest.containsKey("username") || !loginRequest.containsKey("password")) {
                throw new IllegalArgumentException("Username or password is missing");
            }

            String username = loginRequest.get("username");
            String rawPassword = loginRequest.get("password");

            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, rawPassword)
            );

            // Generate JWT token
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtTokenUtil.generateToken(userDetails.getUsername());

            response.put("token", token);
        } catch (BadCredentialsException e) {
            response.put("error", "Invalid username or password");
        } catch (IllegalArgumentException e) {
            response.put("error", e.getMessage());
        } catch (Exception e) {
            response.put("error", "An unexpected error occurred");
        }

        return response;
    }
}
