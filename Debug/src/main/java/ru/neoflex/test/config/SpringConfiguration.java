package ru.neoflex.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

@RestController
public class SpringConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(SpringConfiguration.class);

    @PostMapping
    public Object getObject(HttpServletRequest request) {
        logger.info("POST");
        try {
            InputStreamReader reader = new InputStreamReader(request.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder("\n");
            bufferedReader.lines().forEach(sb::append);
            sb.append("\n\n");
            Collections.list(request.getHeaderNames()).forEach(key -> {
                sb.append(key).append(":").append(request.getHeader(key)).append("\n");
            });

            logger.info(sb.toString());
        } catch (IOException e) {
            logger.error("getObject", e);
        }
        return request;
    }

    @GetMapping
    public String getString(HttpServletRequest request) {
        logger.info("GET request", request);
        return request.getRemoteUser();
    }
}
