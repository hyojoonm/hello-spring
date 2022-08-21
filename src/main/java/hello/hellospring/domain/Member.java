package hello.hellospring.domain;

public class Member {

    private Long id; // 시스템이 정해주는 아이디
    private String name; //고객 회원가입 아이디

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


}
