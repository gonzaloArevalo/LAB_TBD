package com.tbd_grupo_8.lab_1.repositories;
import com.tbd_grupo_8.lab_1.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class ClienteRepositoryImp implements ClienteRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Cliente> getAllClientes() {
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"cliente\"")
                    .executeAndFetch(Cliente.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente findByUsername(String username) {
        return null;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }
}
