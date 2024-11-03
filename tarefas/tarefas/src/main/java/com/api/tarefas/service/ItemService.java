package com.api.tarefas.service;

import com.api.tarefas.model.Item;
import com.api.tarefas.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Método para adicionar um item
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    // Método para remover um item pelo ID
    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Método para atualizar o status do item para "Vendido"
    public Optional<Item> markItemAsSold(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        item.ifPresent(i -> {
            i.setStatus("Vendido");
            itemRepository.save(i);
        });
        return item;
    }

    // Método para listar todos os itens
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
