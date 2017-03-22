import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/job", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/job-post-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String description = request.queryParams("description");
      String title = request.queryParams("title");
      String email = request.queryParams("email");
      Job newJob = new Job(title, description, email);
      request.session().attribute("newJob", newJob);
      model.put("newJob", request.session().attribute("newJob"));
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("newJob", request.session().attribute("newJob"));
      model.put("template", "templates/available-jobs.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
