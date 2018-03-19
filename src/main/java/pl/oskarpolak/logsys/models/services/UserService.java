package pl.oskarpolak.logsys.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.logsys.models.KeyEntity;
import pl.oskarpolak.logsys.models.UserEntity;
import pl.oskarpolak.logsys.models.dto.UserDto;
import pl.oskarpolak.logsys.models.repositories.KeyRepository;
import pl.oskarpolak.logsys.models.repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;
    final KeyRepository keyRepository;

    @Autowired
    public UserService(UserRepository userRepository, KeyRepository keyRepository) {
        this.userRepository = userRepository;
        this.keyRepository = keyRepository;
    }

    public void registerUser(UserDto userDto, KeyEntity key) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getLogin());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setFirstname(userDto.getFirstname());
        userEntity.setSurname(userDto.getSurname());
        userEntity.setKey(key);

        userRepository.save(userEntity);
    }

}
