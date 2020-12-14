import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public class Parsing {

    public static Date yesterday() {
        //потому что он возвращает json по вчерашней дате
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date tomorrow(int n) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    public static String answer(String url) {
        System.out.println();
        System.out.println((char) 27 + "[36mPlease wait..." + (char)27 + "[0m");
        System.out.println();
        String answer = "";
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(1000);
            StringBuilder resp = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = response.readLine()) != null){
                    resp.append(line);
                    resp.append("\n");
                }
            }
            answer = resp.toString();
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return answer;
    }
}
