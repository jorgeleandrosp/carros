
package br.estacio.carros.bean;

import br.estacio.carros.dao.ClienteDAO;
import br.estacio.carros.entidade.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jorge PEREIRA
 * Data: 05/04/2017
 */

@ManagedBean
@SessionScoped
public class ClienteBean extends CrudBean<Cliente, ClienteDAO> {

    private ClienteDAO clienteDAO;
    
    @Override
    public ClienteDAO getDao() {
        if(clienteDAO == null){
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }

    @Override
    public Cliente criarNovaEntidade() {
        return new Cliente();
    }

}