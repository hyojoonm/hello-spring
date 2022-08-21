package hello.hellospring.serivice;

import hello.hellospring.domain.Member;

import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class MemberseriviceTest {

    Memberserivice memberserivice ;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberserivice = new Memberserivice(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() {
        //given   무언가 주어져서
        Member member = new Member();
        member.setName("hello");
        //when    이걸 실행했을때
        Long saveId = memberserivice.join(member);
        //then     이게 나와야 한다
        Member findMember = memberserivice.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberserivice.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberserivice.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
      /*  try{

            memberserivice.join(member2);
            fail();
        } catch(IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}