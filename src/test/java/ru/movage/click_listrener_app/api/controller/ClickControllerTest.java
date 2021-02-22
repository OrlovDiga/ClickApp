package ru.movage.click_listrener_app.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.movage.click_listrener_app.service.ClickService;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Orlov Diga
 */
@ExtendWith(MockitoExtension.class)
class ClickControllerTest {

    private static final int TEST_COUNT = 100;

    @Mock
    private ClickService service;

    @InjectMocks
    private ClickController controller;

    @Test
    void doClick() {
        for (int i = 0; i < TEST_COUNT; i++) {
            int temp = random();
            when(service.saveClick()).thenReturn((long) temp);

            assertEquals(temp, controller.doClick());
        }
    }

    @Test
    void getCurrentClickCount() {
        for (int i = 0; i < TEST_COUNT; i++) {
            int temp = random();
            when(service.getClickCount()).thenReturn((long) temp);

            assertEquals(temp, controller.getCurrentClickCount());
        }
    }

    private int random() {
        return new Random().nextInt(1000) + 100;
    }
}