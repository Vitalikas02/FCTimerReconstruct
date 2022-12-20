import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsonManager {
    File file = new File("timings.json");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    List<JsonData> jsonDataList = new ArrayList<>();
    int butName;
    Date date = new Date();
    SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public JsonManager() throws IOException, ParseException {
    }

    void jsonReader() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("timings.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(Integer.parseInt(String.valueOf(butName)));
        String date = (String) jsonObject.get("date");

        if (Objects.equals(date, "none")){
            jsonReplace();
            //open TimeMath();
        }
    }
    void jsonWriter() throws IOException {
        if (file.exists() && !file.isDirectory()) {
            System.out.println("Файл найден.");
        }
        else
            System.out.println("Файл не найден.");
        for (int i = 0; i < 30; ++i) {
            jsonDataList.add(new JsonData(Frame.butName[i], "test", "none", "none"));
        }
        FileWriter writer = new FileWriter("timings.json");
        writer.write(gson.toJson(jsonDataList));
        writer.close();
    }
    void jsonReplace() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("timings.json"));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonObject = (JSONObject) jsonArray.get(Integer.parseInt(String.valueOf(butName)));

        String dateOutSoloWrite = simpleDate.format(date);
        jsonObject.replace("date", dateOutSoloWrite);
        System.out.println("Значение обновлено!");

        FileWriter writer = new FileWriter("timings.json");
        writer.write(gson.toJson(obj));
        writer.close();
    }
    public void setClick(int butName) throws IOException, ParseException {
        this.butName = butName;
        jsonReader();
    }
}
