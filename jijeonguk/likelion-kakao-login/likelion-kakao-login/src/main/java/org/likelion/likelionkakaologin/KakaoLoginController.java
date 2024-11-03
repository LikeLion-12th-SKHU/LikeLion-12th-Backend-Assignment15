package org.likelion.likelionkakaologin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/callback")
public class KakaoLoginController {

    private final KakaoService kakaoService;

    // 로그인 및 회원가입
    @GetMapping
    public @ResponseBody Token kakaoLogin(@RequestParam("code") String code) {
        String kakaoAccessToken = kakaoService.getAccessToken(code);
        Token token = kakaoService.loginOrSignUp(kakaoAccessToken);
        System.out.println("로그인 성공 !");
        return token;
    }
}