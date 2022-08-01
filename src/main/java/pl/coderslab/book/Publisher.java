package pl.coderslab.book;

import lombok.*;

import javax.persistence.*;

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
    private String name;
}
