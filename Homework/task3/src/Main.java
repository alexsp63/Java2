import org.json.JSONException;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static String city(){
        //получаю название города для ситуации, когда нужно применить уже сохранённые настройки
        String line = "";
        ArrayList<String> content = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3\\settings.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println("Что-то пошло не так!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.get(content.size()-1);
    }

    public static String serviceName(){
        //название сервиса, когда нужно применить сохранённые настройки
        String name = "";
        try{
            FileReader fileReader = new FileReader("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3\\settings.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            name = reader.readLine();
            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println("Что-то пошло не так!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static void input() throws JSONException {
        System.out.println((char) 27 + "[30mВыберите погодный сервис: " +
                "\n   1 - Weatherbit;" +
                "\n   2 - OpenWeather;" +
                "\n   3 - WeatherStack." + (char)27 + "[0m");
        boolean service = false;
        Integer number = -1;
        while(!service){
            System.out.print((char) 27 + "[30m-> " + (char)27 + "[0m");
            try {
                Scanner console = new Scanner(System.in);
                number = console.nextInt();
                if (number >= 1 && number <= 3){
                    //console.close();
                    service = true;
                } else {
                    System.out.println("Выберите из предложенного варианта!");
                }
            } catch (InputMismatchException e){
                System.out.println("Неверный ввод, выберите из предложенного варианта!");
            }
        }
        try {
            FileWriter settings = new FileWriter("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3\\settings.txt", false);
            switch (number) {
                case 1:
                    settings.write("Weatherbit");
                    break;
                case 2:
                    settings.write("OpenWeather");
                    break;
                case 3:
                    settings.write("WeatherStack");
                    break;
            }
            settings.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner console = new Scanner(System.in);
        boolean correct = false;
        String cityName = "";
        String myService = "";
        myService = serviceName();
        while (!correct){
            System.out.print((char) 27 + "[30mВведите город, в котором хотите посмотреть погоду: " + (char)27 + "[0m");
            String city = console.nextLine();
            Weather weather = new Weather(city);
            if (myService.contains("Weatherbit")) {
                correct = weather.getWeatherbit();
            } else if (myService.contains("OpenWeather")) {
                correct = weather.getOpenWeather();
            } else if (myService.contains("WeatherStack")) {
                correct = weather.getWeatherStack();
            }
            cityName = weather.getCityName();
        }
        try {
            FileWriter settings = new FileWriter("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3\\settings.txt", true);
            settings.write("\n" + cityName);
            settings.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkSettings() throws JSONException {
        File settings = new File("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3\\settings.txt");
        if (settings.exists() && !settings.isDirectory()){
            System.out.println((char) 27 + "[30mВыберите опцию: " +
                    "\n   1 - Применить сохранённые настройки;" +
                    "\n   2 - Выбрать заново." + (char)27 + "[0m");
            boolean end = false;
            Integer number = -1;
            while(!end){
                System.out.print((char) 27 + "[30m-> " + (char)27 + "[0m");
                try {
                    Scanner console = new Scanner(System.in);
                    number = console.nextInt();
                    if (number >= 1 && number <= 2){
                        end = true;
                    } else {
                        System.out.println("Выберите из предложенного варианта!");
                    }
                } catch (InputMismatchException e){
                    System.out.println("Неверный ввод, выберите из предложенного варианта!");
                }
            }
            if (number == 1){
                String myService = serviceName();
                String myCity = city();
                Weather weather = new Weather(myCity);
                if (myService.contains("Weatherbit")) {
                    weather.getWeatherbit();
                } else if (myService.contains("OpenWeather")) {
                    weather.getOpenWeather();
                } else if (myService.contains("WeatherStack")) {
                    weather.getWeatherStack();
                }
            }
            else if (number == 2){
                input();
            }
        }
        else{
            input();
        }
        System.out.println();
    }

    public static void main(String[] args) throws JSONException {
        checkSettings();

    }
}

