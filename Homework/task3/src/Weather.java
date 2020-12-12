import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class Weather {
    private String cityName;

    public Weather(String cityName){
        this.cityName = cityName.toLowerCase();
    }

    public String getCityName() {
        return cityName;
    }

    public boolean getWeatherbit() throws JSONException {
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

    public boolean getOpenWeather() throws JSONException {
        String resp = Parsing.answer("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=d536c38953a5a0137578c178f9291f69");
        if (resp.length() != 0) {
            JSONObject current = new JSONObject(resp);
            DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
            String temp = decimalFormat.format(current.getJSONObject("main").getDouble("temp")-273.15);
            String fl = decimalFormat.format(current.getJSONObject("main").getDouble("feels_like")-273.15);
            System.out.println((char) 27 + "[33m*.*.*. Погода в городе " + cityName + " по данным сервиса OpenWeather *.*.*." + (char)27 + "[0m");
            System.out.println();
            System.out.println((char) 27 + "[30mОписание: " +
                    current.getJSONArray("weather").getJSONObject(0).getString("description") + "\n" +
                    "Температура воздуха: " +
                    temp + "°С\n" +
                    "Ощущается как: " +
                    fl + "°С\n" +
                    "Давление: " +
                    String.format("%(.2f мм. рт. столба\n", current.getJSONObject("main").getDouble("pressure")*3/4) +
                    "Влажность: " +
                    current.getJSONObject("main").getDouble("humidity") + "%\n" +
                    "Облачность: " +
                    current.getJSONObject("clouds").getDouble("all") + "%\n" +
                    "Скорость ветра: "
                    + String.format("%(.2f м/с\n", current.getJSONObject("wind").getDouble("speed"))
                    + (char)27 + "[0m");
            return true;
        } else {
            //потому что openweather единственная, которая разрешает название на русском
            System.out.println("Такого города не найдено!");
        }
        return false;
    }

    public boolean getWeatherStack() throws JSONException {
        String resp = Parsing.answer("http://api.weatherstack.com/current?access_key=3b18a54a512557e6d656bc858ded3826&query=" + cityName);
        if (resp.length() != 0) {
            JSONObject current = new JSONObject(resp);
            try{
                current.getJSONObject("current").getJSONArray("weather_descriptions").getString(0);
                System.out.println((char) 27 + "[33m*.*.*. Погода в городе " + cityName + " по данным сервиса WeatherStack *.*.*." + (char)27 + "[0m");
                System.out.println();
                System.out.println((char) 27 + "[30mОписание: "
                        + current.getJSONObject("current").getJSONArray("weather_descriptions").getString(0) + "\n" +
                        "Температура воздуха: "
                        + current.getJSONObject("current").getDouble("temperature") + "°С\n" +
                        "Ощущается как: "
                        + current.getJSONObject("current").getDouble("feelslike") + "°С\n" +
                        "Давление: " +
                        String.format("%(.2f мм. рт. столба\n", current.getJSONObject("current").getDouble("pressure")*3/4) +
                        "Облачность: "
                        + current.getJSONObject("current").getDouble("cloudcover") + "%\n" +
                        "Влажность: "
                        + current.getJSONObject("current").getDouble("humidity") + "%\n" +
                        "Скорость ветра: "
                        + String.format("%(.2f м/с\n", current.getJSONObject("current").getDouble("wind_speed")/7)
                + (char)27 + "[0m");
                return true;
            } catch (JSONException e){
                System.out.println("Данный сервис не может найти введённый город!");
            }
        } else {
            System.out.println("Вы ввели название несуществующего города " +
                    "или данный сайт не выдаёт погоду по русскому названию города, " +
                    "попробуйте снова, используя название на английском!");
        }
        return false;
    }
}