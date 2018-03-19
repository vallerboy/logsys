package pl.oskarpolak.logsys.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "apikey")
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
