package ru.movage.click_listrener_app;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.movage.click_listrener_app.service.ClickService;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class ClickListenerAppApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ClickListenerAppApplication.class);

    private final ClickService service;

	public static void main(String[] args) {
		SpringApplication.run(ClickListenerAppApplication.class, args);
	}

	@Bean
    public CommandLineRunner runner() {
	    return args -> {
	        LOG.info("execute runner");
            service.updateClickSumAndClearClicks();
            service.initClick();
        };
    }

}
