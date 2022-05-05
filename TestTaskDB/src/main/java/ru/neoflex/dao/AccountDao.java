package ru.neoflex.dao;

import ru.neoflex.model.Account;

import java.util.List;

public class AccountDao extends GenericDAO {
    private final GenericDAO<Account> genericDAO;
  //  private AuditDao auditDao;

    public AccountDao(){
        this.genericDAO = new GenericDAO(){};
    }

    public Account save(Account account){
        return this.genericDAO.save(account);
    }

    public boolean update(Account account){
        return this.genericDAO.update(account);
    }

    public Account getAccount(int id){
        return this.genericDAO.find("FROM ru.neoflex.model.Account WHERE id = " + id);
    }

    public List<Account> getAccounts(){
        return this.genericDAO.findList("FROM ru.neoflex.model.Account");
    }
}
