package pl.coderslab.book;

import lombok.*;
import org.hibernate.validator.constraints.pl.NIP;
import org.hibernate.validator.constraints.pl.REGON;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NIP
    private String nip;
    @REGON
    private String regon;
}
