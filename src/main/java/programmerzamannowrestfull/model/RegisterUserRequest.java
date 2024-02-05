package programmerzamannowrestfull.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserRequest {

    @NotBlank(message = "Username cannot be blank")
    @Size(max = 100)
    private String username;
    
    @NotBlank(message = "Password cannot be blank")
    @Size(max = 100)
    private String password;
    
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100)
    private String name;
    
}
