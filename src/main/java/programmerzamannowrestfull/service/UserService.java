package programmerzamannowrestfull.service;

import programmerzamannowrestfull.entity.User;
import programmerzamannowrestfull.model.RegisterUserRequest;
import programmerzamannowrestfull.model.UpdateUserRequest;
import programmerzamannowrestfull.model.UserResponse;

public interface UserService {

    void register(RegisterUserRequest request);

    UserResponse get(User user);
    
    UserResponse update(User user, UpdateUserRequest request);

}
