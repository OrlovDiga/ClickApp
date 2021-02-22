package ru.movage.click_listrener_app.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.movage.click_listrener_app.repo.ClickRepo;
import ru.movage.click_listrener_app.service.ClickService;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Orlov Diga
 */
@Service
@RequiredArgsConstructor
public class ClickServiceImpl implements ClickService {

    private static final Logger LOG = LoggerFactory.getLogger(ClickServiceImpl.class);
    private final ClickRepo repo;
    private final static AtomicLong click = new AtomicLong();

    @Transactional
    @Override
    public long saveClick() {
        repo.saveClick();
        return click.incrementAndGet();
    }

    @Override
    public long initClick() {
        click.set(repo.getClickSum());
        return click.get();
    }

    @Transactional
    @Override
    public void updateClickSumAndClearClicks() {
        repo.updateClickSum();
        repo.cleanClicks();
    }

    @Override
    public long getClickCount() {
        return click.get();
    }
}
