package pac;

import com.google.gson.Gson;

/**
 * Created by bruce on 5/29/2016.
 */
public class SimpleTest {

    private static Gson gson = new Gson();
    public static void printToJson(Object o){
        System.out.println(gson.toJson(o));
    }
}
