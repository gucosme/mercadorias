package DAO;

import entities.Mercadoria;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by gusta on 08/09/2016.
 */
public interface MercadoriaDAOInterface {
    public void insere(Mercadoria mercadoria) throws SQLException;
    public List<Mercadoria> lista() throws SQLException;
}
