
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;


public class RestPostClient {
    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Code : ");
        int code=sc.nextInt();
        System.out.println("Enter Title : ");
        String title=sc.next();
        System.out.println("Enter Subject : ");
        String subject=sc.next();
        System.out.println("Enter Duration : ");
        int dur=sc.nextInt();
        System.out.println("Enter Fees : ");
        int fees=sc.nextInt();
        
        JSONObject json=new JSONObject();
        json.put("code", code);
        json.put("subject", subject);
        json.put("title",title);
        json.put("duration",dur);
        json.put("fees",fees);
                         
        String endPoint="http://localhost:8084/FirstWebService/webapi/course";
        URL url=new URL(endPoint);
        HttpURLConnection con=(HttpURLConnection)url.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        //String json="{\"code\":117,\"duration\":6,\"fees\":15500,\"subject\":\"java\",\"title\":\"projava\"}";
        OutputStream os=con.getOutputStream();
        os.write(json.toString().getBytes());
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
