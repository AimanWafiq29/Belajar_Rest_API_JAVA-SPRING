package programmerzamannowrestfull.service.impl;

import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import programmerzamannowrestfull.entity.User;
import programmerzamannowrestfull.model.LoginUserRequest;
import programmerzamannowrestfull.model.TokenResponse;
import programmerzamannowrestfull.repository.UserRepository;
import programmerzamannowrestfull.security.BCrypt;
import programmerzamannowrestfull.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationServiceImpl validationServiceImpl;

    @Override
    @Transactional
    public TokenResponse Login(LoginUserRequest request) {

        validationServiceImpl.validate(request);

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Username or Password wrong"
        ));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);
            return TokenResponse.builder()
                    .token(user.getToken())
                    .expirredAt(user.getTokenExpiredAt())
                    .build();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "username or password wrong"
            );
        }

    }

    @Override
    @Transactional
    public void logout(User user) {
        user.setToken(null);
        user.setTokenExpiredAt(null);
        userRepository.save(user);
    }

    private Long next30Days() {
        return System.currentTimeMillis() + (1000 * 16 * 24 * 30);
    }

}
