package hello.core.member;

public interface MemberRepository {

    // 회원 가입한 회원 메모리에 저장
    void save(Member member);

    // 회원 찾기 - 회원 아이디로 메모리에 존재하는 회원 찾기
    Member findById(Long memberId);
}
