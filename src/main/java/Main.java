import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalPathExtensionException, IOException {
        String path = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy" +
                "\\src\\test\\resources\\TranslationData.txt";
        Injector injector = Guice.createInjector(new SampleModule());
        //InterGalacticTransactionController controller = injector.getInstance(InterGalacticTransactionController.class);
        TranslationFileReader fileReader = new TranslationFileReader();
        TranslationFileParser fileParser = new TranslationFileParser();
        InterGalacticTransactionService service = new InterGalacticTransactionService(fileReader, fileParser);
        List<String> lines = service.readFile(path);

        for (String line : lines) {
            System.out.println(line + "\n");
        }
        Map<String, String> resultMap = service.parser(lines);
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
