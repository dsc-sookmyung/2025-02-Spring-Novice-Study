package chaewonan.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "refresh_token", updatable = false)
    private String refreshtoken;

    public RefreshToken(Long userId, String refreshtoken) {
        this.userId = userId;
        this.refreshtoken = refreshtoken;
    }

    public RefreshToken update(String newRefreshToken) {
        this.refreshtoken = newRefreshToken;
        return this;
    }
}
