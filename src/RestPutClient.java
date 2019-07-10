import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class RestPutClient {
    public static void main(String[] args) throws Exception {
        String endPoint="http://localhost:8084/FirstWebService/webapi/course";
        URL url=new URL(endPoint);
        HttpURLConnection con=(HttpURLConnection)url.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        String json="{\"code\":117,\"duration\":8,\"fees\":18000,\"subject\":\"java\",\"title\":\"projava\"}";
        OutputStream os=con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        InputStream is=con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String resp="";
        String line = null;
        while ((line = br.readLine()) != null) {
            resp=resp+line;
        }
        System.out.println(resp);
    }
}
