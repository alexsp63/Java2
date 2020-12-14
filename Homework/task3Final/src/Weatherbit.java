import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Weatherbit {
    private String cityName;

    public Weatherbit(String cityName){
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public boolean getCurrent() throws JSONException {
        String resp = Parsing.answer("https://api.weatherbit.io/v2.0/current?city=" + cityName + "&key=96de75f3724043bb8b3d9c8aa2d06d70");
        if (resp.length() != 0) {
            JSONObject current = new JSONObject(resp);
            System.out.println((char) 27 + "[33m*.*.*. Погода в городе " + cityName + " по данным сервиса Weatherbit *.*.*." + (char)27 + "[0m");
            System.out.println();
            System.out.println((char) 27 + "[30mОписание: "
                    + current.getJSONArray("data").getJSONObject(0).getJSONObject("weather").getString("description") + "\n" +
                    "Температура воздуха: "
                    + current.getJSONArray("data").getJSONObject(0).getDouble("temp") + "°С\n" +
                    "Ощущается как: "
                    + current.getJSONArray("data").getJSONObject(0).getDouble("app_temp") + "°С\n" +
                    "Давление: " +
                    String.format("%(.2f мм. рт. столба\n", current.getJSONArray("data").getJSONObject(0).getDouble("pres")*3/4) +
                    "Влажность: "
                    + current.getJSONArray("data").getJSONObject(0).getDouble("rh") + "%\n" +
                    "Облачность: "
                    + current.getJSONArray("data").getJSONObject(0).getDouble("clouds") + "%\n" +
                    "Скорость ветра: "
                    + String.format("%(.2f м/с\n", current.getJSONArray("data").getJSONObject(0).getDouble("wind_spd"))
                    + (char)27 + "[0m");
            return true;
        } else {
            System.out.println("Попробуйте ввести корректное название города на английском!");
        }
        return false;
    }

    public boolean getHourly() throws JSONException {
        String resp = Parsing.answer("https://api.weatherbit.io/v2.0/forecast/daily?city=" + cityName + "&key=96de75f3724043bb8b3d9c8aa2d06d70");
        if (resp.length() != 0) {
            JSONObject current = new JSONObject(resp);
            System.out.println((char) 27 + "[33m*.*.*. Погода в городе " + cityName + " по данным сервиса Weatherbit *.*.*." + (char)27 + "[0m");
            int hours = current.getJSONArray("data").length();

            System.out.println();

            for (int i=0; i<hours; i++){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String newDay = dateFormat.format(Parsing.tomorrow(i));
                System.out.println();
                System.out.println((char) 27 + "[36mПрогноз на " + newDay + ": " + (char)27 + "[0m");
                System.out.println((char) 27 + "[30mОписание: "
                        + current.getJSONArray("data").getJSONObject(i).getJSONObject("weather").getString("description") + "\n" +
                        "Температура воздуха: "
                        + current.getJSONArray("data").getJSONObject(i).getDouble("temp") + "°С\n" +
                        "Давление: " +
                        String.format("%(.2f мм. рт. столба\n", current.getJSONArray("data").getJSONObject(i).getDouble("pres")*3/4) +
                        "Влажность: "
                        + current.getJSONArray("data").getJSONObject(i).getDouble("rh") + "%\n" +
                        "Облачность: "
                        + current.getJSONArray("data").getJSONObject(i).getDouble("clouds") + "%\n" +
                        "Скорость ветра: "
                        + String.format("%(.2f м/с\n", current.getJSONArray("data").getJSONObject(i).getDouble("wind_spd"))
                        + (char)27 + "[0m");
            }
            return true;
        } else {
            System.out.println("Попробуйте ввести корректное название города на английском!");
        }
        return false;
    }
}
