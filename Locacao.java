/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.carros.entidade;

import br.estacio.carros.dao.CrudDAO;
import br.estacio.carros.util.exception.ErroSistema;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Locacao implements CrudDAO<Locacao>{
    
    private Integer id;
    private Date dataLocacao;
    private Cliente cliente;
    private Carro carro;
    private Double preco;
    private Date dataPrevistaEntrega;

    private Date dataEfetivaEntrega;
    private Double multaPorAtraso;

    @Override
    public void salvar(Locacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Locacao entidade) throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Locacao> buscar() throws ErroSistema {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
}
