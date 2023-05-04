package springsaga.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import springsaga.ProductApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { ProductApplication.class })
public class CucumberSpingConfiguration {}
