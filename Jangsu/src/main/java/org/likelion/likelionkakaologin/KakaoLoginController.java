package org.likelion.likelionkakaologin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/callback")
public class KakaoLoginController {
    private final KakaoService kakaoService;

//    @GetMapping
//    public @ResponseBody String kakaoAuth(@RequestParam("code") String code) {
//        return "authorization code : " + code;
//    }

//    @GetMapping()
//    public @ResponseBody String kakaoAccess(@RequestParam("code") String code) {
//        String accessToken = kakaoService.getAccessToken(code);
//        System.out.println(code);
//        return "액세스 토큰 받아오기 성공 ! 액세스 토큰: " + accessToken;
//    }

//    @GetMapping()
//    public @ResponseBody KakaoUserInfo kakaoLoginGetUserInfo(@RequestParam("code") String code) {
//        String accessToken = kakaoService.getAccessToken(code);
//        KakaoUserInfo userInfo = kakaoService.getUserInfo(accessToken);
//        System.out.println("사용자 정보 받아오기 성공!");
//        return userInfo;
//    }

    @GetMapping
    public @ResponseBody Token kakaoLogin(@RequestParam("code") String code) {
        String kakaoAccessToken = kakaoService.getAccessToken(code);
        Token token = kakaoService.loginOrSignUp(kakaoAccessToken);
        System.out.println("로그인 성공 !");
        return token;
    }
}
