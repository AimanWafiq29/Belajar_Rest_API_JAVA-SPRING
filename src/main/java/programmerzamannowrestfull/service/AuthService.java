package programmerzamannowrestfull.service;

import programmerzamannowrestfull.entity.User;
import programmerzamannowrestfull.model.LoginUserRequest;
import programmerzamannowrestfull.model.TokenResponse;

public interface AuthService {

    TokenResponse Login(LoginUserRequest request);

    void logout(User user);

}
