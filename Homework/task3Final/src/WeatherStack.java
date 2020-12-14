import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeatherStack {
    private String cityName;

    public WeatherStack(String cityName){
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public Date yesterday() {
        //потому что он возвращает json по вчерашней дате
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public boolean getCurrent() throws JSONException {
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

    public boolean getHourly() throws JSONException {
        String resp = Parsing.answer("http://api.weatherstack.com/forecast?access_key=3b18a54a512557e6d656bc858ded3826&query=" + cityName);
        if (resp.length() != 0) {
            JSONObject current = new JSONObject(resp);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today = dateFormat.format(yesterday());
            try{
                current.getJSONObject("forecast").getJSONObject(today).getDouble("mintemp");
                System.out.println((char) 27 + "[33m*.*.*. Погода в городе " + cityName + " по данным сервиса WeatherStack *.*.*." + (char)27 + "[0m");
                System.out.println();
                System.out.println((char) 27 + "[30mМинимальная температура воздуха: "
                        + current.getJSONObject("forecast").getJSONObject(today).getDouble("mintemp") + "°С\n" +
                        "Максимальная температура воздуха: "
                        + current.getJSONObject("forecast").getJSONObject(today).getDouble("maxtemp") + "°С\n" +
                        "Восход солнца: " +
                        current.getJSONObject("forecast").getJSONObject(today).getJSONObject("astro").getString("sunrise") + "\n" +
                        "Заход солнца: " +
                        current.getJSONObject("forecast").getJSONObject(today).getJSONObject("astro").getString("sunset") + "\n"
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
