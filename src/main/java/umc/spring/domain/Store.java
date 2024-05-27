package umc.spring.domain;
import lombok.*;
import umc.spring.domain.base.BaseEntity;

import jakarta.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    private Float totalScore;

    @Column(length = 50)
    private String address;

    private String imageUrl;

}
