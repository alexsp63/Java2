package program.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpClass {

    private static String getString(URLConnection conn) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream is = new BufferedInputStream(conn.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String inputLine = "";
        while ((inputLine = br.readLine()) != null){
            sb.append(inputLine);
        }
        return sb.toString();
    }

    public static String getRequest(String urlString){
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            return getString(conn);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String PostRequest(String urlString, String jsonString){
        try{
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
            httpURLConnection.setRequestMethod("POST"); //устанавливаю тип метода
            httpURLConnection.setDoOutput(true); //собираюсь использовать это соединение для вывода
            byte[] out = jsonString.getBytes(StandardCharsets.UTF_8);
            int len = out.length;
            httpURLConnection.setFixedLengthStreamingMode(len);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.connect();
            try (OutputStream outputStream = httpURLConnection.getOutputStream()){
                outputStream.write(out);
            }
            return getString(conn);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String PutRequest(String urlString, String jsonString){
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setDoOutput(true);
            byte[] out = jsonString.getBytes(StandardCharsets.UTF_8);
            int len = out.length;
            httpURLConnection.setFixedLengthStreamingMode(len);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.connect();
            try (OutputStream outputStream = httpURLConnection.getOutputStream()) {
                outputStream.write(out);
            }
            return getString(conn);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static boolean DeleteRequest(String urlString){
        try{
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) conn;
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();
            httpURLConnection.getResponseCode();
            return true;
        } catch (IOException e){
            return false;
        }
    }
}
