package com.jae.nightevent.repositories;

import com.jae.nightevent.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
