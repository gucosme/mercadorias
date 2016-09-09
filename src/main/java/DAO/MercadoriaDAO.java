package DAO;

import entities.Mercadoria;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gusta on 08/09/2016.
 */
public class MercadoriaDAO implements MercadoriaDAOInterface{
    private Connection connection = null;

    public MercadoriaDAO() throws SQLException, URISyntaxException{
        DBUtil dbUtil = new DBUtil();
        connection = dbUtil.getConnection();
    }

    @Override
    public void insere(Mercadoria mercadoria) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS mercadorias (\n");

        stringBuffer.append(")");

        Statement stmt = connection.createStatement();
        stmt.executeUpdate(stringBuffer.toString());
    }

    @Override
    public List<Mercadoria> lista() throws SQLException {
        List<Mercadoria> mercadorias = new ArrayList<>();

        return mercadorias;
    }
}
