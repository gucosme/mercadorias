package DAO;

import entities.Mercadoria;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void insere(Mercadoria mercadoria) throws SQLException, URISyntaxException {
        criaTabela();
        String insere = "INSERT INTO mercadorias VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(insere);
        stmt.setLong(1, mercadoria.getCodigo());
        stmt.setString(2, mercadoria.getTipo());
        stmt.setString(3, mercadoria.getNome());
        stmt.setInt(4, mercadoria.getQuantidade());
        stmt.setFloat(5, mercadoria.getPreco());
        stmt.setString(6, mercadoria.getTipoNegocio());

        stmt.execute();
    }

    @Override
    public List<Mercadoria> lista() throws SQLException, URISyntaxException {
        List<Mercadoria> mercadorias = new ArrayList<>();

        return mercadorias;
    }

    public void criaTabela() throws SQLException, URISyntaxException{
        StringBuffer sqlBuffer = new StringBuffer();
        sqlBuffer.append("CREATE TABLE IF NOT EXISTS mercadorias (\n");
        sqlBuffer.append("codigo integer PRIMARY KEY,\n");
        sqlBuffer.append("tipo text,\n");
        sqlBuffer.append("nome text,\n");
        sqlBuffer.append("quantidade integer,\n");
        sqlBuffer.append("preco numeric,\n");
        sqlBuffer.append("tipoNegocio text)");

        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sqlBuffer.toString());
    }
}
