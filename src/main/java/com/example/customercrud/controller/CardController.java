package com.example.customercrud.controller;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.CardDto;
import com.example.customercrud.entity.Card;
import com.example.customercrud.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;
    @GetMapping
    public List<Card> cardList(){
        List<Card> cards = cardService.cardList();
        return cards;
    }
    @GetMapping("/{id}")
    public Card getCard(@PathVariable Integer id){
        Card card = cardService.getCard(id);
        return card;
    }
    @PostMapping
    public ApiResponse saveCard(@RequestBody  CardDto cardDto){
        ApiResponse savecard = cardService.savecard(cardDto);
        return savecard;
    }
    @GetMapping("/cardPage/{page}")
    public Page<Card> cardPage(@PathVariable Integer page){
        Page<Card> cards = cardService.cardPage(page);
        return cards;
    }
    @PutMapping("/{id}")
    public ApiResponse updateCard(@PathVariable Integer id,@RequestBody CardDto cardDto){
        ApiResponse response = cardService.updateCard(id, cardDto);
        return response;
    }
    @DeleteMapping("/{id}")
    public ApiResponse deleteCard(@PathVariable Integer id){
        ApiResponse response = cardService.deleteCardById(id);
        return response;
    }
}
