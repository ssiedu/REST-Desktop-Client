
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class AllCourses {
     public static void main(String[] args) throws Exception {
        String endPoint = "http://localhost:8084/FirstWebService/webapi/course/json/112/114";
        URL url = new URL(endPoint);
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is));
        String output="",response="";
        
        while ((output = br.readLine()) != null) {
            response=response+output;
        }
        //System.out.println(response);
        
        JSONArray jarr=new JSONArray(response);
        
        for(int i=0; i<jarr.length();i++){
            JSONObject json=jarr.getJSONObject(i);
            int r1=json.getInt("code");
            String r2=json.getString("title");
            String r3=json.getString("subject");
            int r4=json.getInt("duration");
            int r5=json.getInt("fees");
            System.out.println(r1+","+r2+","+r3+","+r4+","+r5);
        }
        
        
        
        
        
        
        
        
    }

}
