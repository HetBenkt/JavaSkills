package nl.bos.data;

import java.util.Set;

public class PersonDTO {
    private Long id;
    private String name;
    private Integer age;
    private Set<String> interests;

    public PersonDTO(final String name, final Integer age, final Set<String> interests) {
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public PersonDTO(final Long id, final String name, final Integer age, final Set<String> interests) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Set<String> getInterests() {
        return interests;
    }

    public void setInterests(final Set<String> interests) {
        this.interests = interests;
    }
}
