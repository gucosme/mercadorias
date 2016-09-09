import com.google.gson.Gson;
import entities.Mercadoria;

import static spark.Spark.*;

public class Main {

	public static void main(String[] args) {
        port(getHerokuAssignedPort());

        Gson gson = new Gson();

        staticFiles.location("/public");

        post("/mercadoria", "application/json", (req, res) -> {
            res.redirect("operacoes.html");
            Mercadoria mercadoria = gson.fromJson(req.body(), Mercadoria.class);

            System.out.println(mercadoria.toString());
            return "";
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