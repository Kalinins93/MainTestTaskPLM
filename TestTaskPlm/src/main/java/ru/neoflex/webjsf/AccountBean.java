package ru.neoflex.webjsf;

import ru.neoflex.dao.AccountDao;
import ru.neoflex.dao.ClientDao;
import ru.neoflex.model.Account;
import ru.neoflex.model.Client;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "AccountBean")
@SessionScoped
public class AccountBean implements Serializable {
    private Account account = new Account();

    public AccountBean() {
        defaultValues();
    }

    public void defaultValues() {
        this.account = new Account();
    }

    public String addAccount() {
        if (new AccountDao().save(this.account) != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Account", "Successfully Added."));

            defaultValues();

            return "Successfully Added.";
        }

        return "fail"; // You can create a specif error.xhtml page and handle here.
    }

    public String updateAccount() {
        if (new AccountDao().update(this.account)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Account", "Successfully Updated."));

            defaultValues();

            return "";
        }

        return ""; // You can create a specif error.xhtml page and handle here.
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Account> getAccounts() {
        return new AccountDao().getAccounts();
    }

    public List<Client> getClients() {
        return new ClientDao().getClients();
    }
}
