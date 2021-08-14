package nl.bos.data;

import java.util.Set;

public class PersonDTO {
    private Long id;
    private String name;
    private Integer age;
    private Set<String> interests;

    public PersonDTO(String name, Integer age, Set<String> interests) {
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public PersonDTO(Long id, String name, Integer age, Set<String> interests) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public PersonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<String> getInterests() {
        return interests;
    }

    public void setInterests(Set<String> interests) {
        this.interests = interests;
    }
}
