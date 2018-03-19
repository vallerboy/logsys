package pl.oskarpolak.logsys.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.oskarpolak.logsys.models.dto.UserDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "userapi")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;
    private String firstname;
    private String surname;

    @Column(name = "is_login")
    private boolean isLogin;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

}
