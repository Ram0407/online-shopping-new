package com.ram.inventoryservice.service;

import com.ram.inventoryservice.model.Inventory;
import com.ram.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        Optional<Inventory> inventory = inventoryRepository.findBySkuCode(skuCode);
        return inventory.isPresent();
    }

}
