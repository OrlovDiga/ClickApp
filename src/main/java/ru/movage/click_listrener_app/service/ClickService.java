package ru.movage.click_listrener_app.service;

import org.springframework.stereotype.Service;

/**
 * @author Orlov Diga
 */
@Service
public interface ClickService {

    long saveClick();

    long initClick();

    void updateClickSumAndClearClicks();

    long getClickCount();
}
