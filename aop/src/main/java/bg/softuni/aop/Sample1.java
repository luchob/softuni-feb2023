package bg.softuni.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sample1 implements CommandLineRunner {

  private final Logger LOGGER = LoggerFactory.getLogger(Sample1.class);

  private final SampleComponent sampleComponent;

  public Sample1(SampleComponent sampleComponent) {
    this.sampleComponent = sampleComponent;
  }

  @Override
  public void run(String... args) throws Exception {
//    sampleComponent.sayHello();
//    sampleComponent.echoSomething("I'm a demo");
//    try {
//      sampleComponent.doSomethingWrong();
//    } catch (Exception npe) {
//      LOGGER.error("Ups an error with message {}", npe.getMessage());
//    }

    String s1 = "string1";
    String s2 = "string2";
    String result = sampleComponent.concatTwoStrings(s1, s2);
    //string1string2

    LOGGER.info("Concatenating {} and {}. Result is {}", s1, s2,
        result);
  }
}
