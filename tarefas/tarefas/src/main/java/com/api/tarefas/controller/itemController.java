package com.api.tarefas.controller;

import com.api.tarefas.model.item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class itemController {
    private List<item> items = new ArrayList<>();

    // Exibe o formulário para adicionar itens
    @GetMapping
    public String showShopPage(Model model) {
        model.addAttribute("items", items);
        return "shop";
    }

    // Adiciona um novo item
    @PostMapping("/add")
    public String addItem(@RequestParam("name") String name, 
                          @RequestParam("price") double price) {
        items.add(new item(name, price));
        return "redirect:/shop";
    }

    // Exibe a página com a lista de itens
    @GetMapping("/items")
    public String showItemsPage(Model model) {
        model.addAttribute("items", items);
        return "items";
    }

    // Compra um item
    @PostMapping("/items/buy")
    public String buyItem(@RequestParam("index") int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).setStatus("Vendido");
        }
        return "redirect:/shop/items";
    }

    // Remove um item
    @PostMapping("/items/remove")
    public String removeItem(@RequestParam("index") int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
        return "redirect:/shop/items";
    }
}