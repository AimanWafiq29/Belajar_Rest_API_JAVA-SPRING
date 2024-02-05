package programmerzamannowrestfull.service.impl;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import programmerzamannowrestfull.entity.User;
import programmerzamannowrestfull.model.RegisterUserRequest;
import programmerzamannowrestfull.model.UpdateUserRequest;
import programmerzamannowrestfull.model.UserResponse;
import programmerzamannowrestfull.security.BCrypt;
import programmerzamannowrestfull.service.UserService;
import programmerzamannowrestfull.repository.UserRepository;
import programmerzamannowrestfull.service.ValidationService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    @Transactional
    public void register(RegisterUserRequest request) {

        validationService.validate(request);

        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    @Override
    public UserResponse get(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    @Override
    public UserResponse update(User user, UpdateUserRequest request) {

        validationService.validate(request);

        if (Objects.nonNull(request.getName())) {
            user.setName(request.getName());
        }

        if (Objects.nonNull(request.getPassword())) {
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        userRepository.save(user);

        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();

    }

}
