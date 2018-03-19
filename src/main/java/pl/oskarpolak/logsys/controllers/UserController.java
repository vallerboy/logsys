package pl.oskarpolak.logsys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.logsys.models.UserEntity;
import pl.oskarpolak.logsys.models.Utils;
import pl.oskarpolak.logsys.models.dto.UserDto;
import pl.oskarpolak.logsys.models.repositories.UserRepository;
import pl.oskarpolak.logsys.models.services.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
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


    @GetMapping("/")
    @ResponseBody
    public String index() {
        return Utils.generateRandomString(512);
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return raportErrors(bindingResult);
        }

        if(userRepository.existsByUsername(userDto.getLogin())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                    .body("Busy username");
        }

        userService.registerUser(userDto);
        return ResponseEntity.ok("Registered");
    }

    @GetMapping(value = "/user/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get(@PathVariable("login") String login){
        Optional<UserEntity> userEntity = userRepository.findByUsername(login);
        if(!userEntity.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not exist");
        }
        return ResponseEntity.ok(userEntity.get());
    }

    @DeleteMapping(value = "/user/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("login") String login){
        userRepository.findByUsername(login).ifPresent(s -> userRepository.delete(s.getId()));
        return ResponseEntity.ok("Try to delete");
    }



    private ResponseEntity raportErrors(BindingResult bindingResult) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(  bindingResult
                        .getFieldErrors()
                        .stream()
                        .map(s -> s.getField() + " : " + s.getDefaultMessage())
                        .collect(Collectors.joining("\n")));
    }

}
