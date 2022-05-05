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

@ManagedBean
@SessionScoped
public class ClientManager implements Serializable {
    private Client client = new Client();
    private ClientDao clientDao = new ClientDao();
        public String addClient(){
            if(clientDao.save(client) != null){
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Client", "Successfully Added."));
                return "";
            }
            return "fail"; // You can create a specif error.xhtml page and handle here.
        }
        public String updateClient(){
            if(new ClientDao().update(this.client)){
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Client", "Successfully Updated."));
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
            return clientDao.getClients();
        }
}
