package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private  static Map<Long,Member> store = new HashMap<>();
    private static  long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 아이디 세팅
        store.put(member.getId(), member); // 스코어에 저장
        return member; // 저장된 결과 반환
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
   public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public List<Member> findALl() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }


}
