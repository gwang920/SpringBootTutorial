package hello.hellospring.respository;

import hello.hellospring.domain.Member;

import java.util.*;

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