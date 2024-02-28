package com.example.springplayground.controller;

import com.example.springplayground.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JpaController {

    final DeviceService deviceService;

    @GetMapping("/jpa/play")
    public Object play() {
        return deviceService.play();
    }

    @GetMapping("/jpa/find")
    public Object find() {
        return deviceService.findByName("device1");
    }

    @GetMapping("/jpa/create-computer")
    public Object createComputer() {
        return deviceService.createComputer();
    }

    @GetMapping("/jpa/find-computers")
    public Object findComputers() {
        return deviceService.findComputersByManufacturer();
    }
}
