package backend.likelion.todos.auth.jwt;

import static java.util.concurrent.TimeUnit.DAYS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

import backend.likelion.todos.common.UnAuthorizedException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final long accessTokenExpirationDayToMills;
    private final Algorithm algorithm;

    public JwtService(JwtProperty jwtProperty) {
        this.accessTokenExpirationDayToMills =
                MILLISECONDS.convert(jwtProperty.accessTokenExpirationDay(), DAYS);
        this.algorithm = Algorithm.HMAC512(jwtProperty.secretKey());
    }

    // 회원 ID를 기반으로 JWT 토큰을 생성합니다.
    public String createToken(Long memberId) {
        Date now = new Date(); // 현재 시간
        Date expiryDate = new Date(now.getTime() + accessTokenExpirationDayToMills); // 만료 시간

        return JWT.create()
                .withClaim("memberId", memberId)
                .withIssuedAt(now)
                .withExpiresAt(expiryDate)
                .sign(algorithm); // 설정된 알고리즘으로 서명
    }

    // 토큰에서 회원 ID를 추출합니다.
    public Long extractMemberId(String token) {
        try {
            // 토큰의 유효성을 검증합니다.
            JWT.require(algorithm)
                    .build()
                    .verify(token);
            // "memberId" 클레임에서 회원 ID를 추출합니다.
            return JWT.decode(token).getClaim("memberId").asLong();
        } catch (JWTVerificationException exception) {
            // 유효하지 않은 경우 예외를 발생시킵니다.
            throw new UnAuthorizedException("유효하지 않은 토큰입니다.");
        }
    }
}
