package nl.bos.vaadincrud;

public enum EAccountService implements IAccountService {
    INSTANCE;

    private final IAccountDAO accountDAO = new AccountDAO();

    @Override
    public AccountDTO getAccount(long id) {
        return accountDAO.getAccount(id);
    }
}
