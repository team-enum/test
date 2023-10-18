package com.codingbox.jpaproject.web;

import org.springframework.stereotype.Component;

import com.codingbox.jpaproject.domain.member.Member;
import com.codingbox.jpaproject.domain.member.MemberRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataInit {
	
	private final MemberRepository memberRepository;

	@PostConstruct
	public void init() {
		Member member = new Member();
		member.setLoginId("test");
		member.setPassword("test1234");
		member.setName("테스트user");
		memberRepository.save(member);
	}
}











