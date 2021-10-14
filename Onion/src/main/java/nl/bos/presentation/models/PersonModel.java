package nl.bos.presentation.models;

import nl.bos.data.PersonDTO;

import java.util.Set;

//todo something abstract/interface!?
public class PersonModel extends PersonDTO {
    public PersonModel(String name, Integer age, Set<String> interests) {
        super(name, age, interests);
    }

    public PersonModel(Long id, String name, Integer age, Set<String> interests) {
        super(id, name, age, interests);
    }
}
