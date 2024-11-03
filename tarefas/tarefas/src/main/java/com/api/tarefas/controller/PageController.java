
package com.api.tarefas.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/shop/items")
    public String showItemsPage() {
        return "items"; // Carrega o arquivo items.html da pasta templates
    }
}