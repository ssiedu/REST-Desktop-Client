import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RestClient {

    public static void main(String[] args) throws Exception {
        String endPoint = "http://localhost:8084/FirstWebService/webapi/course/json/111";
        URL url = new URL(endPoint);
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is));
        String output="",response="";
        
        while ((output = br.readLine()) != null) {
            response=response+output;
        }
        System.out.println(response);
    }

}
