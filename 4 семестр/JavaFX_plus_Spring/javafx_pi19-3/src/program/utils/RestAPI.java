package program.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import program.models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RestAPI {

    private static final String SERVER_URL = "http://127.0.0.1:8080";
    private static final String SERVER_GET_PERSONS = SERVER_URL + "/api/person";

    public List<Person> getPerson(){
        List<Person> result = new ArrayList<>();
        String buffer = HttpClass.getRequest(SERVER_GET_PERSONS);
        JsonArray jsonResult = JsonParser.parseString(buffer).getAsJsonArray();

        for (int i=0; i<jsonResult.size(); i++){
            JsonObject thisPerson = jsonResult.get(i).getAsJsonObject();
            String firstName = thisPerson.get("firstName").getAsString();
            String lastName = thisPerson.get("lastName").getAsString();
            String street = thisPerson.get("street").getAsString();
            String city = thisPerson.get("city").getAsString();
            Integer postalCode = thisPerson.get("postalCode").getAsInt();
            //System.out.println(thisPerson);
            //System.out.println(thisPerson.get("birthDay"));
            LocalDate birthDay = DateUtil.parse(thisPerson.get("birthDay").getAsString());
            Integer id = thisPerson.get("id").getAsInt();

            Person newPerson = new Person(firstName, lastName, street, city, postalCode, birthDay, id);
            //System.out.println(newPerson);
            result.add(newPerson);
        }
        return result;
    }

    public void postPerson(Person newPerson){
        HttpClass.PostRequest(SERVER_GET_PERSONS, newPerson.toJson());
    }

    public void putPerson(Person person){
        Integer id = person.getId();
        String jsonString = person.toJson();
        //System.out.println(jsonString);
        HttpClass.PutRequest(SERVER_GET_PERSONS + "/" + id, jsonString);
    }

    public boolean deletePerson(Person person){
        Integer id = person.getId();
        if (id == null){
            return false;
        }
        return HttpClass.DeleteRequest(SERVER_GET_PERSONS + "/" + id);
    }
}
