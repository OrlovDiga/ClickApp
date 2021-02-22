package ru.movage.click_listrener_app.repo.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.movage.click_listrener_app.repo.ClickRepo;

import javax.persistence.EntityManager;

/**
 * @author Orlov Diga
 */
@Repository
@RequiredArgsConstructor
public class ClickRepoImpl implements ClickRepo {

    private final EntityManager em;

    @Override
    public void saveClick() {
        em.createNativeQuery(
                "INSERT INTO click (clk) VALUES (NULL);")
                .executeUpdate();
    }

    @Override
    public long getClickSum() {
        return ((java.math.BigInteger) em.createNativeQuery(
                "SELECT clk_count FROM click_sum LIMIT 1")
                .getSingleResult())
                .longValue();
    }

    @Override
    public void updateClickSum() {
        em.createNativeQuery(
                "UPDATE click_sum SET clk_count = cnt + clk_count " +
                   "FROM (SELECT count(*) as cnt FROM click) as cnt")
          .executeUpdate();
    }

    @Override
    public void cleanClicks() {
        em.createNativeQuery("DELETE FROM click")
          .executeUpdate();
    }
}
