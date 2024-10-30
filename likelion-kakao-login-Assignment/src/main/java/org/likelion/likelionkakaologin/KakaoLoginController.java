package org.likelion.likelionkakaologin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/callback")
public class KakaoLoginController {

    private final KakaoService kakaoService;

    // authorization code(인가코드)를 받아오는 역할(테스트용)
//    @GetMapping
//    public @ResponseBody String kakaoLogin(@RequestParam("code")String code) {
//        return "authorization code : " + code;
//    }

    // 액세스 토큰을 받아오는 역할(테스트용)
//    @GetMapping
//    public @ResponseBody String kakaoLogin(@RequestParam("code") String code) {
//        String accessToken = kakaoService.getAccessToken(code);
//        return "액세스 토큰 받아오기 성공 ! 액세스 토큰: " + accessToken;
//    }

    // 사용자 정보를 받아오는 역할(테스트용)
//    @GetMapping
//    public @ResponseBody KakaoUserInfo kakaoLogin(@RequestParam("code") String code) {
//        String accessToken = kakaoService.getAccessToken(code);
//        KakaoUserInfo userInfo = kakaoService.getUserInfo(accessToken);
//        System.out.println("사용자 정보 받아오기 성공 !");
//        return userInfo;
//    }

    // 로그인 및 회원가입
    @GetMapping
    public @ResponseBody Token kakaoLogin(@RequestParam("code") String code) {
        String kakaoAccessToken = kakaoService.getAccessToken(code);
        Token token = kakaoService.loginOrSignUp(kakaoAccessToken);
        System.out.println("로그인 성공 !");
        return token;
    }
}