package XmltoJson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Conversion {
    public static  String Readfile(String Folderlocation,String Filename)
    {
        String filePath = Folderlocation+Filename;

        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    public static String convert(String xmlInput) {
        String jsonOutput=null;
        try {
            // Create XmlMapper to read XML
            XmlMapper xmlMapper = new XmlMapper();

            // Create ObjectMapper to write JSON
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Read XML as JsonNode
            JsonNode jsonNode = xmlMapper.readTree(xmlInput.getBytes());

            // Convert JsonNode to JSON string
            jsonOutput = jsonMapper.writeValueAsString(jsonNode);

            // Print JSON output
            System.out.println(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonOutput;
    }
    public static void main(String[] args)
    {
       String Folder="E:\\SpringBoot\\RMD\\XMLtoJSON\\src\\main\\resources\\";
       String file="Sample.xml";
      String xmlInput=Readfile(Folder,file);
      String json=convert(xmlInput);
    }
}
