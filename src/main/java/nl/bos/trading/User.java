package nl.bos.trading;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private final String name;
    private final String email;
}
