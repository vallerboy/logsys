package pl.oskarpolak.logsys.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
