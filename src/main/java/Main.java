import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileParser;
import org.amaap.merchantsguidetogalaxy.IO.TranslationFileReader;
import org.amaap.merchantsguidetogalaxy.IO.exception.IllegalPathExtensionException;
import org.amaap.merchantsguidetogalaxy.repository.InterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.InMemoryInterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.impl.FakeDatabase;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalPathExtensionException, IOException {
        String filePath = "D:\\AMAAP Training\\Project with mvc\\MerchantGuideToTheGalaxy" +
                "\\src\\test\\resources\\TranslationData.txt";
        Injector injector = Guice.createInjector(new SampleModule());
        //InterGalacticTransactionController controller = injector.getInstance(InterGalacticTransactionController.class);
        InMemoryDataBase inMemoryDataBase = new FakeDatabase();
        TranslationFileReader fileReader = new TranslationFileReader();
        TranslationFileParser fileParser = new TranslationFileParser();
        InterGalacticRepository repository = new InMemoryInterGalacticRepository(inMemoryDataBase);
        InterGalacticTransactionService service = new InterGalacticTransactionService(fileReader, fileParser,repository);
        List<String> lines = fileReader.readFile(filePath);
        for (String line :lines) {
            System.out.println(line + "\n");

        }
        service.readFileAndParse(filePath);

//        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

    }
}
