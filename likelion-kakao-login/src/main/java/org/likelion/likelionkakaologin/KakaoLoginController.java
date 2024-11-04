package org.likelion.likelionkakaologin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/callback")
public class KakaoLoginController {

    // authorization code(인가코드)를 받아오는 역할(테스트용)
    private final KakaoService kakaoService;

    @GetMapping
    public @ResponseBody Token kakaoLogin(@RequestParam("code") String code) {
        String kakaoAccessToken = kakaoService.getAccessToken(code);
        Token token = kakaoService.loginOrSignUp(kakaoAccessToken);
        System.out.println("로그인 성공 !");
        return token;
    }
}
