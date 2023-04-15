package com.ctu.Library.auth;

import com.ctu.Library.ExceptionHandling.CustomException;
import com.ctu.Library.Librarian.Librarian;
import com.ctu.Library.Librarian.LibrarianRepository;
import com.ctu.Library.Reader.Reader;
import com.ctu.Library.Reader.ReaderRepository;
import com.ctu.Library.User.DTO.UserResponseDTO;
import com.ctu.Library.User.Role;
import com.ctu.Library.User.User;
import com.ctu.Library.User.UserMapper;
import com.ctu.Library.User.UserRepository;
import com.ctu.Library.config.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
  private final ReaderRepository readerRepository;
  private final LibrarianRepository librarianRepository;

    private final AuthenticationManager authenticationManager;
    public AuthenticateResponse register(RegisterRequest request){
        String requestUsername = request.getUserName();
        Optional<User> existUser = userRepository.findByUserName(requestUsername);
        if (existUser.isPresent()) throw new CustomException("Username đã tồn tại", HttpStatus.CONFLICT);
        User user = User.builder()
                .name("")
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
                .name(request.getName())
                .phone((request.getPhone()))
                .gender(request.getGender())
                .build();
        User newUser = userRepository.save(user);
        Reader reader = Reader.builder().user(newUser).hasUpdateInfo(false).build();
        readerRepository.save(reader);
        String token = jwtService.signToken(user);
        return AuthenticateResponse.builder()
                .token(token)
                .id(newUser.getId())
                .email(newUser.getEmail())
                .gender(newUser.getGender())
                .phone(newUser.getPhone())
                .name(newUser.getName())
                .role(newUser.getRole())
                .userName(newUser.getUsername())
                .build();
    }
  public AuthenticateResponse registerLibrarian(RegisterRequest request){
      String requestUsername = request.getUserName();
      Optional<User> existUser = userRepository.findByUserName(requestUsername);
      if (existUser.isPresent()) throw new CustomException("Username đã tồn tại", HttpStatus.CONFLICT);
      User user = User.builder()
            .name("")
            .userName(request.getUserName())
            .password(passwordEncoder.encode(request.getPassword()))
            .email(request.getEmail())
            .role(Role.ADMIN)
            .name(request.getName())
            .phone((request.getPhone()))
            .gender(request.getGender())
            .build();
      User newUser = userRepository.save(user);
      String token = jwtService.signToken(user);
      Librarian librarian = Librarian.builder().user(newUser).hasUpdateInfo(false).build();
      librarianRepository.save(librarian);
      return AuthenticateResponse.builder()
            .token(token)
            .id(newUser.getId())
            .email(newUser.getEmail())
            .gender(newUser.getGender())
            .phone(newUser.getPhone())
            .name(newUser.getName())
            .role(newUser.getRole())
            .userName(newUser.getUsername())
            .build();
  }


    public AuthenticateResponse authenticate(AuthenticateRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(()->new CustomException("Tài khoản " + request.getUserName()+ " không tồn tại", HttpStatus.NOT_FOUND));
        String token = jwtService.signToken(user);
        return AuthenticateResponse.builder()
                .token(token)
                .id(user.getId())
                .email(user.getEmail())
                .gender(user.getGender())
                .phone(user.getPhone())
                .name(user.getName())
                .role(user.getRole())
                .userName(user.getUsername())
                .build();
    }

    public UserResponseDTO getIdentity(String token){
        String userName = jwtService.extractUserName(token);
        User user = userRepository.findByUserName(userName).
                orElseThrow(() -> new CustomException("Không tìm thấy tài khoản với username là " + userName , HttpStatus.NOT_FOUND));
        System.out.println(user);
        UserResponseDTO userResponseDTO = userMapper.modelTODTO(user);
        userResponseDTO.setToken(token);
        return userResponseDTO;
    }
}
