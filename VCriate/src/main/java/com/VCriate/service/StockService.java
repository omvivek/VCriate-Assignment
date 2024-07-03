package com.VCriate.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VCriate.model.Item;
import com.VCriate.repository.ItemRepository;

@Service
public class StockService {
    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Optional<Item> existingItemOptional = itemRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            Item existingItem = existingItemOptional.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setQuantity(updatedItem.getQuantity());
            return itemRepository.save(existingItem);
        }
        return null; // Or throw an exception indicating item not found
    }

    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}

