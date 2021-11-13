package nl.bos.vaadincrud;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import java.util.List;

public class AccountDAO implements IAccountDAO {
    @Override
    public AccountDTO getAccount(long id) {
        WebClient client = WebClient.builder()
                .defaultHeaders(header -> header.setBasicAuth("user", "password"))
                .build();
        RequestHeadersSpec<?> spec = client.
                get().
                uri(String.format("http://localhost:8080/api/account/%s", id));
        return spec.retrieve().
                toEntity(AccountDTO.class).
                block().
                getBody();
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        WebClient client = WebClient.builder()
                .defaultHeaders(header -> header.setBasicAuth("user", "password"))
                .build();
        RequestHeadersSpec<?> spec = client.
                get().
                uri("http://localhost:8080/api/account");
        return spec.retrieve().
                toEntityList(AccountDTO.class).
                block().
                getBody();
    }
}
