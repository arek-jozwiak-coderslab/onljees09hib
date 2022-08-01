package pl.coderslab.dog;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nameDog;
    @Column(name = "owner_name")
    private String ownerName;
    @Transient
    private String ownerNickName;


}
