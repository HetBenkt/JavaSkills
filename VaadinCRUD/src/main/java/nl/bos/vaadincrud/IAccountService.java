package nl.bos.vaadincrud;

import java.util.List;

public interface IAccountService {
    AccountDTO getAccount(long id);

    List<AccountDTO> getAllAccounts();
}
