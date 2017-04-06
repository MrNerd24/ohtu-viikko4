package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {
    public static Course course;

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "014417883";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        url = "https://ohtustats2017.herokuapp.com/courses/1.json";

        bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        mapper = new Gson();
        Course course = mapper.fromJson(bodyText, Course.class);
        Main.course = course;

        System.out.println("");
        System.out.println("opiskelijanumero: " + studentNr);
        System.out.println("");

        int exercises = 0;
        int hours = 0;
        for (Submission submission : subs) {
            exercises += submission.getExercises();
            hours += submission.getHours();
            System.out.println(submission);

        }
        System.out.println("");
        System.out.println("yhteensä: " + exercises + " tehtävää " + hours + " tuntia");
    }
}
