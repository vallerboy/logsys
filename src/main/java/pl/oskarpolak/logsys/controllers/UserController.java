package pl.oskarpolak.logsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.oskarpolak.logsys.models.UserEntity;
import pl.oskarpolak.logsys.models.dto.UserDto;
import pl.oskarpolak.logsys.models.repositories.UserRepository;
import pl.oskarpolak.logsys.models.services.UserService;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class UserController {

    final UserRepository userRepository;
    final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(  bindingResult
                            .getFieldErrors()
                            .stream()
                            .map(s -> s.getField() + " : " + s.getDefaultMessage())
                            .collect(Collectors.joining("\n")));
        }

        if(userRepository.existsByLogin(userDto.getLogin())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                    .body("Busy login");
        }

        userService.registerUser(userDto);
        return ResponseEntity.ok("Registered");
    }

}
