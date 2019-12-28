package jackson.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * author yg
 * description
 * date 2019/12/14
 */
public class JsonTypeInfoTest {
    public static void main(String[] args) {
        String inputJson = " {\n" +
                "        \"type\": \"input0\",\n" +
                "        \"label\": \"标题\",\n" +
                "        \"uiType\": \"input\",\n" +
                "        \"input\" : \"lvsheng\"\n" +
                "        \n" +
                "      }";
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputPage inputPageModel = ((InputPage) mapper.readValue(inputJson, Page.class));
            System.out.println(inputPageModel.getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String numberJson = " {\n" +
                "        \"type\": \"number0\",\n" +
                "        \"label\": \"价格\",\n" +
                "        \"uiType\": \"input\",\n" +
                "        \"number\" : 110\n" +
                "        \n" +
                "      }";
        try {
            NumberPage numberPageModel = ((NumberPage) mapper.readValue(numberJson, Page.class));
            System.out.println(numberPageModel.getNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

