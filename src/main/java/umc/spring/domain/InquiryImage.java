package umc.spring.domain;

import lombok.*;
import umc.spring.domain.base.BaseEntity;

import jakarta.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InquiryImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id")
    private Inquiry inquiry;
}
