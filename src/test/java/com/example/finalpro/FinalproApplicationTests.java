package com.example.finalpro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinalproApplicationTests {

    @Autowired
    private ScheduledDraw scheduledDraw;

    @Test
    void contextLoads() {
    }
}
