package br.estacio.carros.dao;

import br.estacio.carros.util.exception.ErroSistema;
import java.util.List;

public interface CrudDAO<E> {//E representa minha entidade
    
    public void salvar(E entidade) throws ErroSistema;
    public void deletar(E entidade) throws ErroSistema;
    public List<E> buscar() throws ErroSistema;
    
}
