package ru.movage.click_listrener_app.scheduler;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.movage.click_listrener_app.service.ClickService;

/**
 * @author Orlov Diga
 */
@Component
@RequiredArgsConstructor
public class UpdateDbScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateDbScheduler.class);
    private static int counter = 0;

    private static final int MILLISECONDS = 10000;

    private final ClickService service;

    @Scheduled(fixedDelay = MILLISECONDS)
    public void updateDb() {
        LOG.info("execute update {}", ++counter);
        service.updateClickSumAndClearClicks();
    }
}
