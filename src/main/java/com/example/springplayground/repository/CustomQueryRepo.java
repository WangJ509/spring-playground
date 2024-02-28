package com.example.springplayground.repository;

import org.springframework.data.domain.Example;

import java.util.Date;
import java.util.List;

public interface CustomQueryRepo<T> {

    <S extends T> List<S> findByDataTimeBetween(Example<S> example, Date start, Date end);
}
