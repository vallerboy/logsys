package pl.oskarpolak.logsys.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;

@Table(name = "keys")
@Entity
@Data
@NoArgsConstructor
public class KeyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String key;
    private String name;

}
