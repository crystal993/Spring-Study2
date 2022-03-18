package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    // 회원 찾아야 하니깐 memberRepository 필요
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 주문 정책
//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
// 추상과 구체화 둘 다에 의존하고 있다. DIP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

//    이렇게 하면 인터페이스에만 의존이 가능하다.
    // 실행하면 null포인터예외 오류
    private DiscountPolicy discountPolicy;
    private MemberRepository memberRepository;

    // 생성자 주입
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);

        // 설계가 잘 된 것임, srp 단일 책임 원칙이 잘 지켜졌다.
        // 할인 쪽 변경이 일어나면 할인 쪽만 바꾸면 된다.
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
