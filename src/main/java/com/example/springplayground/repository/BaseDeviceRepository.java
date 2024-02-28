package com.example.springplayground.repository;

import com.example.springplayground.entity.BaseDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDeviceRepository extends JpaRepository<BaseDevice, Long>, CustomQueryRepo<BaseDevice> {
    List<BaseDevice> findByName(String name);
}
