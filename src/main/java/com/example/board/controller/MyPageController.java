package com.example.board.controller;

import com.example.board.dto.MemberDTO;
import com.example.board.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final MemberService memberService;

    // 마이페이지 보기
    @GetMapping("/mypage")
    public String mypage(Model model,
                         @SessionAttribute(name = "member", required = false) MemberDTO member) {
        if(member == null) {
            return "redirect:/login";
        }
        model.addAttribute("member", member);
        return "mypage";  // templates/mypage.html
    }

    // 마이페이지 수정 화면
    @GetMapping("/mypageModify")
    public String showModifyPage(Model model,
                                 @SessionAttribute(name = "member", required = false) MemberDTO member) {
        if(member == null) {
            return "redirect:/login";
        }
        model.addAttribute("member", member);
        return "mypageModify";  // templates/mypageModify.html
    }

    // 마이페이지 수정 처리
    @PostMapping("/mypageModify")
    public String modifyMember(MemberDTO memberDto, HttpServletRequest request) {
        log.info("modify member: {}", memberDto);
        // 필요한 회원 정보 수정 로직을 추가 (예: memberService.update(memberDto);)
        // 세션 업데이트
        String email = memberService.update(memberDto);
        request.getSession().setAttribute("member", memberDto);
        return "redirect:/mypage";
    }
}
