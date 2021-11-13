package nl.bos.vaadincrud;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import java.util.List;

public class AccountDAO implements IAccountDAO {

    private static final String HOST = "http://localhost:8080";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private final WebClient client;

    public AccountDAO() {
        client = WebClient.builder()
                .defaultHeaders(header -> header.setBasicAuth(USER, PASSWORD))
                .build();
    }

    @Override
    public AccountDTO getAccount(long id) {
        RequestHeadersSpec<?> spec = client.
                get().
                uri(String.format("%s/api/account/%s", HOST, id));
        return spec.retrieve().
                toEntity(AccountDTO.class).
                block().
                getBody();
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        RequestHeadersSpec<?> spec = client.
                get().
                uri(String.format("%s/api/account", HOST));
        return spec.retrieve().
                toEntityList(AccountDTO.class).
                block().
                getBody();
    }
}