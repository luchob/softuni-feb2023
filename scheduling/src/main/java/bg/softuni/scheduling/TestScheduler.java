package bg.softuni.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {

  private Logger LOGGER = LoggerFactory.getLogger(TestScheduler.class);

  @Scheduled(fixedRate = 5000)
  public void doInBackground() {
    LOGGER.info("In my scheduler!");
  }

}
