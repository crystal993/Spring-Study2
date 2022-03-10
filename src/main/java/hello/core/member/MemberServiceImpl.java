package hello.core.member;

public class MemberServiceImpl implements MemberService{

//    DIP, OCP 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 이제 MemoryMemberRepository가 존재하지 않는다.
    // 오로지 memberRepository만 존재한다. - DIP 지킴, 이제 추상화만 의존함.
    // MemberServiceImpl은 추상클래스인 MemberRepository에만 의존한다.
    // DIP를 지킴.
    private final MemberRepository memberRepository;

    // AppConfig는 생성한 구현 인스턴스 객체를 생성자를 통해서 주입 해준다.
    // MemberServiceImpl에서 어떤 MemberRepository가 들어올 지는 알 수 없다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
