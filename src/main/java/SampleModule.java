import com.google.inject.AbstractModule;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

public class SampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InterGalacticTransactionService.class);
    }
}
