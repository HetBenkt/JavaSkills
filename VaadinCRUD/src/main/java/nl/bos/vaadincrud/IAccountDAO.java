package nl.bos.vaadincrud;

import java.util.List;

public interface IAccountDAO {
    AccountDTO getAccount(long id);

    List<AccountDTO> getAllAccounts();
}
