package com.example.springplayground.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "computers")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Computer extends BaseDevice {

    String manufacturer;
}
