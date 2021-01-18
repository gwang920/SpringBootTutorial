package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.respository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository= new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void save(){
        Member member=new Member();
        member.setName("spring");

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findID(member.getId()).get();
        Assertions.assertThat(result).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1=new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result=memoryMemberRepository.findName(member1.getName()).get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1=new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2=new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        List<Member> list=memoryMemberRepository.findAll();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }

}
