package programmerzamannowrestfull.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programmerzamannowrestfull.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    private Validator validator;
    
    @Override
    public void validate(Object request) {
        Set<ConstraintViolation<Object>> constraintViolations
                = validator.validate(request);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

}
