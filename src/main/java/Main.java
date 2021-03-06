import DAO.MercadoriaDAO;
import com.google.gson.Gson;
import entities.Mercadoria;

import static spark.Spark.*;

public class Main {

	public static void main(String[] args) {
        port(getHerokuAssignedPort());

        staticFiles.location("/public");

        post("/mercadoria", (req, res) -> {
            res.redirect("/");

            Mercadoria mercadoria = new Mercadoria();
            mercadoria.setCodigo( Long.parseLong( req.queryParams("codigo-mercadoria") ) );
            mercadoria.setTipo( req.queryParams("tipo-mercadoria") );
            mercadoria.setNome( req.queryParams("nome-mercadoria") );
            mercadoria.setQuantidade( Integer.parseInt( req.queryParams("quantidade-mercadoria") ) );
            mercadoria.setPreco( Float.parseFloat( req.queryParams("preco-mercadoria") ) );
            mercadoria.setTipoNegocio( req.queryParams("tipo-negocio") );

            new MercadoriaDAO().insere(mercadoria);
            return "";
        });

        get("/teste", (req, res) -> {
            return new MercadoriaDAO().lista().toString();
        });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}