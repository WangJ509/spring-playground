package com.example.springplayground.service;

import com.example.springplayground.entity.BaseDevice;
import com.example.springplayground.entity.Computer;
import com.example.springplayground.repository.BaseDeviceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    final BaseDeviceRepository baseDeviceRepository;

    @Transactional
    public BaseDevice play() {
        var baseDevice = BaseDevice.builder()
                .name("device1")
                .dataTime(new Date())
                .build();

        return baseDeviceRepository.save(baseDevice);
    }

    public List<BaseDevice> findByName(String name) {
        Example<BaseDevice> example = Example.of(BaseDevice.builder().name(name).build());

        return baseDeviceRepository.findByDataTimeBetween(example, new Date(0), new Date());
    }

    @Transactional
    public Computer createComputer() {
        var computer = Computer.builder()
                .name("computer1")
                .dataTime(new Date())
                .manufacturer("Dell")
                .build();

        return baseDeviceRepository.save(computer);
    }

    public List<Computer> findComputersByManufacturer() {
        Example<Computer> example = Example.of(Computer.builder().manufacturer("Dell").build());

        return baseDeviceRepository.findByDataTimeBetween(example, new Date(0), new Date());
    }

}
