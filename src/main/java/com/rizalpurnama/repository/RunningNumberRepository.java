package com.rizalpurnama.repository;

import com.rizalpurnama.entity.RunningNumber;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;

public interface RunningNumberRepository extends CrudRepository<RunningNumber, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    RunningNumber findByPrefix(String prefix);
}
