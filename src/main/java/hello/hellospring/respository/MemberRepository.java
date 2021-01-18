package hello.hellospring.respository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findID(long id);
    Optional<Member> findName(String Name);
    List<Member> findAll();
}