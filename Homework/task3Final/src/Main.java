import org.json.JSONException;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static String parametr(int i){
        //получаю для ситуации, когда нужно применить уже сохранённые настройки
        String line = "";
        ArrayList<String> content = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3Final\\settings.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e){
            System.out.println("Что-то пошло не так!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.get(i);
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
            FileWriter settings = new FileWriter("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3Final\\settings.txt", false);
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
        if (number != 3){
            System.out.println((char) 27 + "[30mЭто будет... " +
                    "\n   1 - текущая погода;" +
                    "\n   2 - почасовой прогноз." + (char)27 + "[0m");
        } else if (number == 3) {
            System.out.println((char) 27 + "[30mЭто будет... " +
                    "\n   1 - текущая погода;" +
                    "\n   2 - прогноз на сегодняшний день." + (char)27 + "[0m");
        }
        boolean period = false;
        Integer num = -1;
        while(!period){
            System.out.print((char) 27 + "[30m-> " + (char)27 + "[0m");
            try {
                Scanner console = new Scanner(System.in);
                num = console.nextInt();
                if (num >= 1 && num <= 2){
                    period = true;
                } else {
                    System.out.println("Выберите из предложенного варианта!");
                }
            } catch (InputMismatchException e){
                System.out.println("Неверный ввод, выберите из предложенного варианта!");
            }
        }
        try {
            FileWriter settings = new FileWriter("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3Final\\settings.txt", true);
            switch (num) {
                case 1:
                    settings.write("\ncurrent");
                    break;
                case 2:
                    settings.write("\nhourly");
                    break;
            }
            settings.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Scanner console = new Scanner(System.in);
        boolean correct = false;
        String cityName = "";
        String myService = "";
        myService = parametr(0);
        while (!correct){
            System.out.print((char) 27 + "[30mВведите город, в котором хотите посмотреть погоду: " + (char)27 + "[0m");
            Scanner console = new Scanner(System.in);
            String city = console.nextLine();
            if (myService.contains("Weatherbit")){
                Weatherbit weatherbit = new Weatherbit(city);
                if (num==1){
                    correct = weatherbit.getCurrent();
                } else if (num==2){
                    correct = weatherbit.getHourly();
                }
                cityName = weatherbit.getCityName();
            } else if (myService.contains("OpenWeather")) {
                OpenWeather openWeather = new OpenWeather(city);
                if (num==1){
                    correct = openWeather.getCurrent();
                } else if (num==2){
                    correct = openWeather.getHourly();
                }
                cityName = openWeather.getCityName();
            } else if (myService.contains("WeatherStack")) {
                WeatherStack weatherStack = new WeatherStack(city);
                if (num==1){
                    correct = weatherStack.getCurrent();
                } else if (num==2){
                    correct = weatherStack.getHourly();
                }
                cityName = weatherStack.getCityName();
            }
        }
        try {
            FileWriter settings = new FileWriter("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3Final\\settings.txt", true);
            settings.write("\n" + cityName);
            settings.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkSettings() throws JSONException {
        File settings = new File("C:\\Users\\1\\Desktop\\2 курс\\Java\\Homework\\task3Final\\settings.txt");
        if (settings.exists() && !settings.isDirectory()){
            System.out.println((char) 27 + "[30mВыберите опцию: " +
                    "\n   1 - Применить сохранённые настройки;" +
                    "\n   2 - Выбрать заново;" +
                    "\n   0 - Выход." + (char)27 + "[0m");
            boolean end = false;
            Integer number = -1;
            while(!end){
                System.out.print((char) 27 + "[30m-> " + (char)27 + "[0m");
                try {
                    Scanner console = new Scanner(System.in);
                    number = console.nextInt();
                    if (number >= 0 && number <= 2){
                        end = true;
                    } else {
                        System.out.println("Выберите из предложенного варианта!");
                    }
                } catch (InputMismatchException e){
                    System.out.println("Неверный ввод, выберите из предложенного варианта!");
                }
            }
            if (number == 1){
                String myService = parametr(0);
                String period = parametr(1);
                String myCity = parametr(2);
                if (myService.contains("Weatherbit")) {
                    Weatherbit weatherbit = new Weatherbit(myCity);
                    if (period.contains("current")){
                        weatherbit.getCurrent();
                    } else if (period.contains("hourly")){
                        weatherbit.getHourly();
                    }
                } else if (myService.contains("OpenWeather")) {
                    OpenWeather openWeather = new OpenWeather(myCity);
                    if (period.contains("current")){
                        openWeather.getCurrent();
                    } else if (period.contains("hourly")){
                        openWeather.getHourly();
                    }
                } else if (myService.contains("WeatherStack")) {
                    WeatherStack weatherStack = new WeatherStack(myCity);
                    if (period.contains("current")){
                        weatherStack.getCurrent();
                    } else if (period.contains("hourly")){
                        weatherStack.getHourly();
                    }
                }
            }
            else if (number == 2){
                input();
            }
            else if (number == 0){
                return true;
            }
        }
        else{
            input();
        }
        System.out.println();
        return false;
    }

    public static void main(String[] args) throws JSONException {
        boolean end = false;
        while (!end){
            end = checkSettings();
        }

    }
}