package com.jae.nightevent.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {
    private int id;
    private String name;
    private int quantity;
}
