package com.api.tarefas.controller;

import com.api.tarefas.model.Item;
import com.api.tarefas.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Endpoint para adicionar um novo item
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item savedItem = itemService.addItem(item);
        return ResponseEntity.ok(savedItem);
    }

    // Endpoint para remover um item pelo ID
    @PostMapping("/remove/{id}")
    public ResponseEntity<Void> removeItem(@PathVariable Long id) {
        itemService.removeItem(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para marcar um item como vendido
    @PutMapping("/markAsSold/{id}")
    public ResponseEntity<Item> markAsSold(@PathVariable Long id) {
        return itemService.markItemAsSold(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para listar todos os itens
    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
}
