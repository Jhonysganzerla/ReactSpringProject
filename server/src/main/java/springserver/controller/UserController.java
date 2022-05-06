package springserver.controller;

import org.springframework.http.ResponseEntity;
import springserver.error.ApiError;
import springserver.model.User;
import springserver.service.GenericCrudService;
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
public class UserController extends GenericCrudController<User,Long> {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public GenericResponse signup(@Valid @RequestBody User user) {
        userService.save(user);
        return new GenericResponse("User registered successfully");
    }

    @Override
    protected GenericCrudService<User, Long> getService() {
        return userService;
    }
}
