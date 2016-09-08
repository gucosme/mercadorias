import static spark.Spark.*;

public class Main {

	public static void main(String[] args) {
        port(getHerokuAssignedPort());

        staticFiles.location("/public");

        post("/mercadoria", (req, res) -> {
            return req.queryParams("tipo-negocio");
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