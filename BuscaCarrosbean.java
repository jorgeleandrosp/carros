/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.carros.bean;

import br.estacio.carros.dao.CarroDAO;
import br.estacio.carros.entidade.Carro;
import br.estacio.carros.util.FabricaConexao;
import br.estacio.carros.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jorge PEREIRA
 */
@ManagedBean
@ViewScoped
public class BuscaCarrosbean {
    private Carro carro;
    
    public Carro getCarro(){
        return carro;
    }
    
    public void setCarro(Carro carro){
        this.carro = carro;
    }
    @PostConstruct
    public void novo(){
        carro = new Carro();
    }
    
    public void buscar(){
        CarroDAO carroDAO = new CarroDAO();
        Carro resultado = carroDAO.buscar(carro.getPlaca());
        carroDAO.buscar(carro.getPlaca());
    
   
}
}