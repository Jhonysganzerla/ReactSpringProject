package springserver.controller;

import org.springframework.http.ResponseEntity;
import springserver.error.ApiError;
import springserver.model.User;
import springserver.service.UserService;
import springserver.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/signup")
    public GenericResponse signup(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User registered successfully");
    }
//    GenericResponse createUser(@Valid @RequestBody User user) {
//        userService.save(user);
//
//        return new GenericResponse("Registro salvo.");
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError handlerValidationException(MethodArgumentNotValidException exception,
                                        HttpServletRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }
        return new ApiError(HttpStatus.BAD_REQUEST.value(),
                "validation error",
                request.getServletPath(),
                validationErrors);
    }

    /*@ExceptionHandler({org.springframework.dao.DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ApiError handlerValidationException(org.springframework.dao.DataIntegrityViolationException exception,
                                        HttpServletRequest request) {
        Map<String, String> validationErrors = new HashMap<>();

        validationErrors.put("username", "Esse usuário já existe, escolha outro");

        return new ApiError(HttpStatus.BAD_REQUEST.value(),
                "validation error",
                request.getServletPath(),
                validationErrors);
    }*/
}
