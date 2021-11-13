package nl.bos.vaadincrud;

import java.util.List;

public enum EAccountService implements IAccountService {
    INSTANCE;

    private final IAccountDAO accountDAO = new AccountDAO();

    @Override
    public AccountDTO getAccount(long id) {
        return accountDAO.getAccount(id);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }
}
