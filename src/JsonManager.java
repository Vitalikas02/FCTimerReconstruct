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

    void jsonReader() {
        try {
            Object obj = new JSONParser().parse(new FileReader("timings.json"));
            JSONArray jsonArray = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) jsonArray.get(Integer.parseInt(String.valueOf(butName)));
            String date = (String) jsonObject.get("date");

            if (Objects.equals(date, "none")){
                jsonReplace();
                //open TimeMath();
            }
            else
                System.out.println("Значение уже существует. Хотите перезаписать?");
            Frame.modalReplace.setVisible(true);
        } catch (IOException e) {
            System.out.println("[ERROR] Не удалось прочитать файл. Код ошибки: ");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            System.out.println("[ERROR] Не удалось прочитать значение файла. Код ошибки: ");
            throw new RuntimeException(e);
        }
    }
    void jsonWriter() {
        if (file.exists() && !file.isDirectory()) {
            System.out.println("Файл найден.");
            return;
        }
        //Хуйня ебаная
        else
            System.out.println("Файл не найден.");
        for (int i = 0; i < 30; ++i) {
            jsonDataList.add(new JsonData(Frame.butName[i], "test", "none", "none"));
        }

        try {
            FileWriter writer = new FileWriter("timings.json");
            writer.write(gson.toJson(jsonDataList));
            writer.close();
        } catch (IOException e) {
            System.out.println("[ERROR] Не удалось записать файл. Код ошибки: ");
            throw new RuntimeException(e);
        }

    }
    void jsonReplace() {
        try {
            Object obj = new JSONParser().parse(new FileReader("timings.json"));
            JSONArray jsonArray = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) jsonArray.get(Integer.parseInt(String.valueOf(butName)));
            String dateOutSoloWrite = simpleDate.format(date);
            jsonObject.replace("date", dateOutSoloWrite);
            FileWriter writer = new FileWriter("timings.json");
            writer.write(gson.toJson(obj));
            writer.close();
        } catch (IOException e) {
            System.out.println("[ERROR] Не удалось прочитать/записать файл. Код ошибки: ");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            System.out.println("[ERROR] Не удалось получить значение файла. Код ошибки: ");
            throw new RuntimeException(e);
        }
        System.out.println("Значение обновлено успешно!");
        Frame.modalReplace.setVisible(false);
    }
    public void setClick(int butName) {
        this.butName = butName;
        jsonReader();
    }
}
