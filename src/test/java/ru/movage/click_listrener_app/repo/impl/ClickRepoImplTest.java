package ru.movage.click_listrener_app.repo.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Orlov Diga
 */
@ExtendWith(MockitoExtension.class)
class ClickRepoImplTest {

    @Mock
    private EntityManager em;

    @InjectMocks
    private ClickRepoImpl repo;

    private Query query;
    private ArgumentCaptor<String> sql;

    @BeforeEach
    void setUp() {
        query = mock(Query.class);
        sql = ArgumentCaptor.forClass(String.class);
    }

    @Test
    void saveClick() {
        doReturn(query).when(em)
                .createNativeQuery(sql.capture());

        repo.saveClick();

        verify(query).executeUpdate();
        assertEquals(sql.getValue(), "INSERT INTO click (clk) VALUES (NULL);");
    }

    @Test
    void getClickSum() {
        BigInteger temp = new BigInteger(random(), new Random());
        doReturn(query).when(em).createNativeQuery(sql.capture());
        doReturn(temp).when(query).getSingleResult();

        assertEquals(temp.longValue(), repo.getClickSum());
        assertEquals(sql.getValue(), "SELECT clk_count FROM click_sum LIMIT 1");
    }

    @Test
    void updateClickSum() {
        doReturn(query).when(em).createNativeQuery(sql.capture());

        repo.updateClickSum();

        verify(query).executeUpdate();
        assertEquals(sql.getValue(), "UPDATE click_sum SET clk_count = cnt + clk_count " +
                                           "FROM (SELECT count(*) as cnt FROM click) as cnt");
    }

    @Test
    void cleanClicks() {
        doReturn(query).when(em).createNativeQuery(sql.capture());

        repo.cleanClicks();

        verify(query).executeUpdate();
        assertEquals(sql.getValue(), "DELETE FROM click");

    }

    private int random() {
        return new Random().nextInt(1000) + 100;
    }

}