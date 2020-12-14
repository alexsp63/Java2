import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class OpenWeather {
    private String cityName;

    public OpenWeather(String cityName){
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean getCurrent() throws JSONException {
        String resp = Parsing.answer("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=d536c38953a5a0137578c178f9291f69");
        if (resp.length() != 0) {
            JSONObject current = new JSONObject(resp);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String temp = decimalFormat.format(current.getJSONObject("main").getDouble("temp") - 273.15);
            String fl = decimalFormat.format(current.getJSONObject("main").getDouble("feels_like") - 273.15);
            System.out.println((char) 27 + "[33m*.*.*. Погода в городе " + cityName + " по данным сервиса OpenWeather *.*.*." + (char) 27 + "[0m");
            System.out.println();
            System.out.println((char) 27 + "[30mОписание: " +
                    current.getJSONArray("weather").getJSONObject(0).getString("description") + "\n" +
                    "Температура воздуха: " +
                    temp + "°С\n" +
                    "Ощущается как: " +
                    fl + "°С\n" +
                    "Давление: " +
                    String.format("%(.2f мм. рт. столба\n", current.getJSONObject("main").getDouble("pressure") * 3 / 4) +
                    "Влажность: " +
                    current.getJSONObject("main").getDouble("humidity") + "%\n" +
                    "Облачность: " +
                    current.getJSONObject("clouds").getDouble("all") + "%\n" +
                    "Скорость ветра: "
                    + String.format("%(.2f м/с\n", current.getJSONObject("wind").getDouble("speed"))
                    + (char) 27 + "[0m");
            return true;
        } else {
            //потому что openweather единственная, которая разрешает название на русском
            System.out.println("Такого города не найдено!");
        }
        return false;
    }

    public boolean getHourly() throws JSONException {
        String resp = Parsing.answer("http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=d536c38953a5a0137578c178f9291f69");
        if (resp.length() != 0) {
            JSONObject current = new JSONObject(resp);
            int hours = current.getJSONArray("list").length();
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            String temp = decimalFormat.format(current.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp") - 273.15);
            String fl = decimalFormat.format(current.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("feels_like") - 273.15);
            System.out.println((char) 27 + "[33m*.*.*. Погода в городе " + cityName + " по данным сервиса OpenWeather *.*.*." + (char) 27 + "[0m");

            System.out.println();
            System.out.println((char) 27 + "[30mNow: " + (char)27 + "[0m");
            System.out.println((char) 27 + "[30mОписание: " +
                    current.getJSONArray("list").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description") + "\n" +
                    "Температура воздуха: " +
                    temp + "°С\n" +
                    "Ощущается как: " +
                    fl + "°С\n" +
                    "Давление: " +
                    String.format("%(.2f мм. рт. столба\n", current.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("pressure") * 3 / 4) +
                    "Влажность: " +
                    current.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("humidity") + "%\n" +
                    "Облачность: " +
                    current.getJSONArray("list").getJSONObject(0).getJSONObject("clouds").getDouble("all") + "%\n" +
                    "Скорость ветра: "
                    + String.format("%(.2f м/с\n", current.getJSONArray("list").getJSONObject(0).getJSONObject("wind").getDouble("speed"))
                    + (char) 27 + "[0m");
            for (int i=1; i<hours; i++){
                temp = decimalFormat.format(current.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("temp") - 273.15);
                fl = decimalFormat.format(current.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("feels_like") - 273.15);

                System.out.println();
                System.out.println((char) 27 + "[30mIn " + i + " hours: " + (char)27 + "[0m");
                System.out.println((char) 27 + "[30mОписание: " +
                        current.getJSONArray("list").getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description") + "\n" +
                        "Температура воздуха: " +
                        temp + "°С\n" +
                        "Ощущается как: " +
                        fl + "°С\n" +
                        "Давление: " +
                        String.format("%(.2f мм. рт. столба\n", current.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("pressure") * 3 / 4) +
                        "Влажность: " +
                        current.getJSONArray("list").getJSONObject(i).getJSONObject("main").getDouble("humidity") + "%\n" +
                        "Облачность: " +
                        current.getJSONArray("list").getJSONObject(i).getJSONObject("clouds").getDouble("all") + "%\n" +
                        "Скорость ветра: "
                        + String.format("%(.2f м/с\n", current.getJSONArray("list").getJSONObject(i).getJSONObject("wind").getDouble("speed"))
                        + (char) 27 + "[0m");
            }
            return true;
        } else {
            System.out.println("Такого города не найдено!");
        }
        return false;
    }

}
