package ru.movage.click_listrener_app.service.impl;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.movage.click_listrener_app.repo.ClickRepo;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Orlov Diga
 */
@ExtendWith(MockitoExtension.class)
class ClickServiceImplTest {

    private static final int TEST_COUNT = 100;

    @Mock
    private ClickRepo clickRepo;

    @InjectMocks
    private ClickServiceImpl service;

    @Test
    public void saveClick() {
        //test mock execute
        doNothing().when(clickRepo).saveClick();
        long temp = service.getClickCount();

        assertEquals(++temp, service.saveClick());
        verify(clickRepo).saveClick();
        //test increment
        for (int i = 0; i < TEST_COUNT; i++) {
            doNothing().when(clickRepo).saveClick();
            temp = service.getClickCount();

            assertEquals(++temp, service.saveClick());
        }

    }

    @Test
    public void initClick() {
        for (int i = 0; i < TEST_COUNT; i++) {
            long temp = random();
            doReturn(temp).when(clickRepo).getClickSum();

            long initedSumClick = service.initClick();

            assertEquals(temp, initedSumClick);
        }
    }

    @Test
    public void updateClickSumAndClearClicks() {
            doNothing().when(clickRepo).updateClickSum();
            doNothing().when(clickRepo).cleanClicks();

            service.updateClickSumAndClearClicks();

            verify(clickRepo).updateClickSum();
            verify(clickRepo).cleanClicks();
    }

    @Test
    public void getClickCount() {
        for (int i = 0; i < TEST_COUNT; i++) {
            long temp = service.getClickCount();

            assertEquals(temp, service.getClickCount());
        }
    }

    private int random() {
        return new Random().nextInt(1000) + 100;
    }
}