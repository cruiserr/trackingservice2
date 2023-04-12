package edu.iu.c322.trackingservice.controller;

import edu.iu.c322.trackingservice.handler.InvalidOrderIdorItemIdException;
import edu.iu.c322.trackingservice.model.*;
import edu.iu.c322.trackingservice.repository.ItemStatusRepository;
import edu.iu.c322.trackingservice.repository.TrackingRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/trackings")
public class TrackingController {

    //private TrackingRepository repository;

    @Autowired
    private ItemStatusRepository itemStatusRepository;

    // this is bad it is binding this class the customerRepository so instead we use spring dependency injection
    /*
    public CustomerController() {
        this.repository = new CustomerRepository();
    }
     */

    //this is dpeendency injection

    /*
    public TrackingController(TrackingRepository repository) {
        this.repository = repository;
    }


     */



    @GetMapping("/{id}/{iid}")
    public ItemStatusDto findByOrderIdandItemId(@Valid @PathVariable int id, @Valid @PathVariable int iid){

        ItemStatus itemStatus = itemStatusRepository.findByOrderIdandItemId(id, iid);

        if (itemStatus == null){
            throw new InvalidOrderIdorItemIdException("order item with this id does not exist in the system");

        }

            ItemStatusDto itemStatusDto = new ItemStatusDto();
            itemStatusDto.setStatus(itemStatus.getStatus());
            itemStatusDto.setDate(itemStatus.getDate());

            return itemStatusDto;

    }

    /*
    //@valid tells spring to ensure validations are checked, our validation is currently in the customer class
    @PostMapping
    public int create(@Valid @RequestBody Invoice invoice){
        return repository.create(invoice);
    }

     */

    // PUT lcoalhost:8080.customers/2
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody UpdateItemStatusDto itemStatusDto, @PathVariable int id){
        ItemStatus itemStatus = itemStatusRepository.findByOrderIdandItemId(id, itemStatusDto.getItemId());

        itemStatusRepository.delete(itemStatus);

        itemStatus.setStatus(itemStatusDto.getStatus());

        itemStatusRepository.save(itemStatus);


    }




}