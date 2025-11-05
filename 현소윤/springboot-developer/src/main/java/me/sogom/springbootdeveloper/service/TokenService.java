package me.sogom.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sogom.springbootdeveloper.config.jwt.TokenProvider;
import me.sogom.springbootdeveloper.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        //token 유효성 검사에 실패하면 예외 발생
        if (!tokenProvider.validToken(refreshToken)) {  //refresh token으로 유효성 검사
            throw new IllegalArgumentException("Unexpected token");
        }
        //refresh token으로 user id 검색
        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        //user id로 find user
        User user = userService.findById(userId);
        //token 제공자의 generateToken() method 호출, new access token create
        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
