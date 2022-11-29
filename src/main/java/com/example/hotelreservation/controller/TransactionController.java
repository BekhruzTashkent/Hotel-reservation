package com.example.hotelreservation.controller;

import com.example.hotelreservation.entity.Transaction;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.TransactionDTO;
import com.example.hotelreservation.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Transaction> all = transactionService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public HttpEntity<?> findById(@PathVariable Integer id){
        Transaction transaction = transactionService.findById(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody TransactionDTO transactionDTO){
        ApiResponse apiResponse = transactionService.addTransaction(transactionDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public HttpEntity<?> update(@PathVariable Integer id, @RequestBody TransactionDTO transactionDTO){
        ApiResponse apiResponse = transactionService.updateTransaction(id, transactionDTO);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deleteQA(@PathVariable Integer id){
        ApiResponse apiResponse = transactionService.deleteTransaction(id);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
