package com.rizalpurnama.service;

import com.rizalpurnama.entity.RunningNumber;
import com.rizalpurnama.repository.RunningNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @Transactional
public class RunningNumberService {

    @Autowired private RunningNumberRepository runningNumberRepository;

    public Long getLastNumber(String prefix){

        RunningNumber rn = runningNumberRepository.findByPrefix(prefix);
        if (rn == null){
            rn = new RunningNumber();
            rn.setPrefix(prefix);
        }

        rn.setLastNumber(rn.getLastNumber() + 1);
        runningNumberRepository.save(rn);

        return rn.getLastNumber();
    }
}
