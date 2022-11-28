package com.example.hotelreservation.service;

import com.example.hotelreservation.entity.Booking;
import com.example.hotelreservation.entity.Transaction;
import com.example.hotelreservation.payload.ApiResponse;
import com.example.hotelreservation.payload.TransactionDTO;
import com.example.hotelreservation.repository.BookingRepository;
import com.example.hotelreservation.repository.TransactionRepository;
import com.example.hotelreservation.service.TranzactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TranzactionService {
    
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookingRepository bookingRepository;
    
    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public Transaction findById(Integer id){
        Optional<Transaction> byId = transactionRepository.findById(id);
        return byId.orElse(null);
    }
    
    public ApiResponse addTransaction(TransactionDTO transactionDTO){

        Optional<Booking> byId = bookingRepository.findById(transactionDTO.getBookingId());
        if(byId.isEmpty()){
            return new ApiResponse("no such booking repository", false);
        }

        Transaction transaction = new Transaction();
        transaction.setDate(transactionDTO.getDate());
        transaction.setMethodOfPayment(transactionDTO.getMethodOfPayment());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setBooking(byId.get());
        transactionRepository.save(transaction);


        return new ApiResponse("added", true);

    }

    public ApiResponse updateTransaction(Integer id, TransactionDTO transactionDTO){

        Optional<Transaction> byId = transactionRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such transaction id", false);
        }

        Optional<Booking> byId2 = bookingRepository.findById(transactionDTO.getBookingId());
        if(byId.isEmpty()){
            return new ApiResponse("no such booking repository", false);
        }

        Transaction transaction = byId.get();
        transaction.setDate(transactionDTO.getDate());
        transaction.setMethodOfPayment(transactionDTO.getMethodOfPayment());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setBooking(byId2.get());
        transactionRepository.save(transaction);

        return new ApiResponse("updated", true);

    }

    public ApiResponse deleteTransaction(Integer id){
        Optional<Transaction> byId = transactionRepository.findById(id);
        if(byId.isEmpty()){
            return new ApiResponse("no such transaction id", false);
        }

        transactionRepository.deleteById(id);
        return new ApiResponse("deleted", true);

    }
    
}
