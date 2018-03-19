package pl.oskarpolak.logsys.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.logsys.models.UserEntity;
import pl.oskarpolak.logsys.models.dto.UserDto;
import pl.oskarpolak.logsys.models.repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getLogin());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setFirstname(userDto.getFirstname());
        userEntity.setSurname(userDto.getSurname());


        userRepository.save(userEntity);
    }

}
