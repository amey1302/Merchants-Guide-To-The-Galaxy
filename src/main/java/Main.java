import com.google.inject.Guice;
import com.google.inject.Injector;
import org.amaap.merchantsguidetogalaxy.controller.InterGalacticTransactionController;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SampleModule());
        InterGalacticTransactionController controller = injector.getInstance(InterGalacticTransactionController.class);

    }

}
