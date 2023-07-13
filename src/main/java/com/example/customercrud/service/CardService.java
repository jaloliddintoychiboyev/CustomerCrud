package com.example.customercrud.service;

import com.example.customercrud.dto.ApiResponse;
import com.example.customercrud.dto.CardDto;
import com.example.customercrud.entity.Card;
import com.example.customercrud.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;

    public List<Card> cardList() {
        List<Card> all = cardRepository.findAll();
        return all;
    }

    public Page<Card> cardPage(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Card> all = cardRepository.findAll(pageable);
        return all;
    }

    public Card getCard(Integer id) {
        Card card = cardRepository.findById(id).get();
        return card;
    }

    public ApiResponse savecard(CardDto cardDto) {
            Card card = new Card();
            card.setCard_number(cardDto.getCard_number());
            card.setBalance(cardDto.getBalance());
            card.setPassword(cardDto.getPassword());
            card.setBank_name(cardDto.getBank_name());
            cardRepository.save(card);
            ApiResponse apiResponse = new ApiResponse("Successful Saved card", true);
            return apiResponse;
    }

    public ApiResponse updateCard(Integer id, CardDto cardDto) {
        boolean b = cardRepository.existsById(id);
        if (b) {
            Card card = cardRepository.findById(id).get();
            card.setCard_number(cardDto.getCard_number());
            card.setBalance(cardDto.getBalance());
            card.setPassword(cardDto.getPassword());
            card.setBank_name(cardDto.getBank_name());
            cardRepository.save(card);
            ApiResponse response = new ApiResponse("Successful Update Card", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not Found!", false);
            return response;
        }
    }

    public ApiResponse deleteCardById(Integer id) {
        boolean b = cardRepository.existsById(id);
        if (b) {
            cardRepository.deleteById(id);
            ApiResponse response = new ApiResponse("Successful Delete Card!", true);
            return response;
        } else {
            ApiResponse response = new ApiResponse("Id Not found!", false);
            return response;
        }
    }
}
