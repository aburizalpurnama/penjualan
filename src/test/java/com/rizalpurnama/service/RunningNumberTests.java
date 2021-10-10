package com.rizalpurnama.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RunningNumberTests {

    @Autowired private RunningNumberService runningNumberService;

    @Test
    void testRunningNumber() throws InterruptedException {
        Long lastNumber = runningNumberService.getLastNumber("test");
        System.out.println(lastNumber);
    }

    @Test
    void testMultipleThread() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    Long lastNumber = runningNumberService.getLastNumber("test");
                    System.out.println("Thread : " + this.getId() + ", Last Number :" + lastNumber);
                }
            };
            t.start();
        }
        Thread.sleep(3000);
    }
}
