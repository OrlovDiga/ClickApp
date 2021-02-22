package ru.movage.click_listrener_app.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.movage.click_listrener_app.service.ClickService;

/**
 * @author Orlov Diga
 */
@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/click")
@RequiredArgsConstructor
public class ClickController {

    private final ClickService service;

    @PostMapping("/increment")
    public long doClick() {
        log.info("click!");
        return service.saveClick();
    }

    @GetMapping()
    public long getCurrentClickCount() {
        log.info("get click!");
        return service.getClickCount();
    }
}
