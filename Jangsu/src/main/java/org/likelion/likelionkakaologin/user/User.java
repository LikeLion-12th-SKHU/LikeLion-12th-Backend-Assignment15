package org.likelion.likelionkakaologin.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_PICTURE_URL")
    private String pictureUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE", nullable = false)
    private Role role;
}
