package ru.neoflex.webjsf;

import ru.neoflex.dao.AccountDao;
import ru.neoflex.dao.ClientDao;
import ru.neoflex.model.Account;
import ru.neoflex.model.Client;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="ClientBean")
@SessionScoped
public class ClientBean implements Serializable {
   private Client client=new Client();

    public ClientBean(){
        defaultValues();
    }

    public void defaultValues(){
        this.client = new Client();
    }
    public String addClient(){
        if(new ClientDao().save(this.client) != null){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Client", "Successfully Added."));

            defaultValues();

            return "";
        }

        return "fail"; // You can create a specif error.xhtml page and handle here.
    }

    public String updateClient(){
        if(new ClientDao().update(this.client)){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Client", "Successfully Updated."));

            defaultValues();

            return "";
        }

        return ""; // You can create a specif error.xhtml page and handle here.
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getClients(){
        return new ClientDao().getClients();
    }
}
