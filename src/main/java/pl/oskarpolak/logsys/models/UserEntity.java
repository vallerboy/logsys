package pl.oskarpolak.logsys.models;

import lombok.Data;
import lombok.Getter;
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
    @Column(name = "login")
    private String username;
    private String password;
    private String firstname;
    private String surname;

    @Column(name = "is_login")
    private boolean isLogin;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToOne
    @JoinColumn(name = "key_id")
    private KeyEntity key;


}
