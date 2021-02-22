package ru.movage.click_listrener_app.repo;

/**
 * @author Orlov Diga
 */
public interface ClickRepo {

    void saveClick();

    long getClickSum();

    void updateClickSum();

    void cleanClicks();
}
