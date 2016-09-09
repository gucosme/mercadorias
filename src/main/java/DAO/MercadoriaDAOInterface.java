package DAO;

import entities.Mercadoria;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by gusta on 08/09/2016.
 */
public interface MercadoriaDAOInterface {
    public void insere(Mercadoria mercadoria) throws SQLException, URISyntaxException;
    public List<Mercadoria> lista() throws SQLException, URISyntaxException;
}
