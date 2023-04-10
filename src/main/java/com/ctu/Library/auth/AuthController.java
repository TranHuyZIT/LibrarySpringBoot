package com.ctu.Library.auth;


import com.ctu.Library.User.DTO.UserResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;


    @Transactional(rollbackOn = {Throwable.class, Exception.class})
    @RequestMapping(method = RequestMethod.POST, path="/register")
    public ResponseEntity<AuthenticateResponse> register(@RequestBody RegisterRequest request){
        AuthenticateResponse response = authService.register(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Transactional(rollbackOn = {Throwable.class, Exception.class})
    @RequestMapping(method = RequestMethod.POST, path="/register-librarian")
    public ResponseEntity<AuthenticateResponse> registerLibrarian(@RequestBody RegisterRequest request){
        AuthenticateResponse response = authService.registerLibrarian(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path="/login")
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request){
        AuthenticateResponse response = authService.authenticate(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/identity")
    public UserResponseDTO getIdentity(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        token = token.replace("Bearer", "");
        UserResponseDTO response = authService.getIdentity(token);
        return response;
    }
}
