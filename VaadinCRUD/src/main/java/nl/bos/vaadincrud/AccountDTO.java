package nl.bos.vaadincrud;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AccountDTO {
    private Long id;
    private String name;
    private Integer age;
}
