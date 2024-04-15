import com.google.inject.AbstractModule;
import org.amaap.merchantsguidetogalaxy.repository.InterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.InMemoryInterGalacticRepository;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.InMemoryDataBase;
import org.amaap.merchantsguidetogalaxy.repository.impl.db.impl.FakeDatabase;
import org.amaap.merchantsguidetogalaxy.service.InterGalacticTransactionService;

public class SampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InterGalacticTransactionService.class);
        bind(InterGalacticRepository.class).to(InMemoryInterGalacticRepository.class);
        bind(InMemoryDataBase.class).to(FakeDatabase.class);
    }
}
