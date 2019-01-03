package br.com.cwi.treinamento.it.baseTest;

import br.com.cwi.treinamento.it.util.Log;
import br.com.cwi.treinamento.hello.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@ActiveProfiles("it")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
public class BaseTest {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            Log.addSeparator();
            log.info("Iniciando teste " + description.getMethodName());
        }

        protected void succeeded(Description description) {
            Log.addBlankLine(2);
            log.info("Teste " + description.getMethodName() + " finalizado. Status: SUCCESS");
        }

        protected void failed(Throwable e, Description description) {
            Log.addBlankLine(2);
            log.info("Teste " + description.getMethodName() + " finalizado. Status: FAILED");
            log.info(e.getMessage());
        }

        protected void finished(Description description) {
            Log.addSeparator();
            Log.addBlankLine();
        }
    };

}
