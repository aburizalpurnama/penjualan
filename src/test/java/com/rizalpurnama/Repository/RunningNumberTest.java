package com.rizalpurnama.Repository;

import com.rizalpurnama.entity.RunningNumber;
import com.rizalpurnama.repository.RunningNumberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RunningNumberTest {

    @Autowired private RunningNumberRepository runningNumberRepository;

    @Test
    void testInsert() {
        RunningNumber rn = new RunningNumber();
        rn.setPrefix("test");

        Assertions.assertNull(rn.getId());

        runningNumberRepository.save(rn);

        Assertions.assertNotNull(rn.getId());
    }
}
