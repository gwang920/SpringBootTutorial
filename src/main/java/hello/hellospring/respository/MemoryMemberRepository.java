package hello.hellospring.respository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long,Member> store= new HashMap<>();
    private static long sequence =0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findID(long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     Map을 순회하기 위해, iterator() 대신에 stream()을 사용하고,
     filter()로 조건에 맞는지 판단한다.
     findAny()는 비어 있는 스트림에서는 비어있는 Optional 객체를 반환한다.

     * iterator()
     컬렉션에 저장되어 있는 요소들을 읽어오는 방법 중의 하나
     **/
    @Override
    public Optional<Member> findName(String Name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(Name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
