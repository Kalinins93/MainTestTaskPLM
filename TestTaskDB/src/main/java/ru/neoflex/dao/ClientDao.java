package ru.neoflex.dao;


import ru.neoflex.model.Client;

import java.util.List;

public class ClientDao extends GenericDAO {
    private final GenericDAO<Client> genericDAO;
  //  private AuditDao auditDao;

    public ClientDao(){
        this.genericDAO = new GenericDAO(){};
    }

    public Client save(Client client){
        return this.genericDAO.save(client);
    }

    public boolean update(Client client){
        return this.genericDAO.update(client);
    }

    public Client getClient(int id){
        return this.genericDAO.find("FROM ru.neoflex.model.Client WHERE id = " + id);
    }

    public List<Client> getClients(){
        return this.genericDAO.findList("FROM ru.neoflex.model.Client ORDER BY username");
    }
}
