
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class RestDeleteClient {
    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Code : ");
        int code=sc.nextInt();
        String endPoint="http://localhost:8084/FirstWebService/webapi/course/"+code;
        URL url=new URL(endPoint);
        HttpURLConnection con=(HttpURLConnection)url.openConnection();
        con.setRequestMethod("DELETE");
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
