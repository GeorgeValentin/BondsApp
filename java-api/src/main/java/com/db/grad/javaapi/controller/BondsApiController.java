package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dtos.ActiveBondDataDto;
import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import com.db.grad.javaapi.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class BondsApiController {

    public static final Logger logger = LogManager.getLogger(BondsApiController.class);

    @Autowired
    private BondService bondService;

    @Autowired
    private UserService userService;

    @GetMapping("/users/{user_id}/activeBonds")
    public ResponseEntity<List<ActiveBondDataDto>> getActiveBonds(@PathVariable(value = "user_id") int userId) {
        return ResponseEntity.ok().body(bondService.getActiveBonds(userId));
    }

    @GetMapping("/bonds")
    public ResponseEntity<List<BondCardDataDto>> getBonds() {
        List<BondCardDataDto> bonds = bondService.getAllBonds();

        if(bonds.size() == 0) {
            logger.info("There are no bonds present! Returning an empty list!");
        } else {
            logger.info("There are" + bonds.size() + " bonds present! Returning the list containing them!");
        }

        return ResponseEntity.ok().body(bonds);
    }

    @GetMapping("/users/{user_id}/bonds/{bond_id}")
    public ResponseEntity<Bond> getBondsById(
            @PathVariable(value = "user_id") Integer userId,
            @PathVariable(value = "bond_id") Integer bondId) {
        Optional<Bond> result = bondService.getBondsById(userId, bondId);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        }return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{user_id}/bonds/maturity")
    public ResponseEntity<List<BondCardDataDto>> getBondsInMaturityTimeframe(
            @PathVariable(value = "user_id") Integer userId
    ) {
        logger.info("BondsApiController::Retrieving bonds in the default maturity timeframe.");
        return ResponseEntity.ok().body(bondService.getBondsInMaturityTimeframe(userId));
    }

    @GetMapping("/users/{user_id}/books")
    public ResponseEntity<List<String>> getBooksNamesforUserID(@PathVariable(value = "user_id") Integer user_id) {
        logger.info("BondsApiController::Retrieving books for user_id");
        Optional<List<String>> result = userService.getBooksNamesforUserID(user_id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        }return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{user_id}/books/{book_name}/bonds")
    public ResponseEntity<List<BondCardDataDto>> getBondsInEachBookForUser(@PathVariable(value = "user_id") Integer user_id,
                                                                           @PathVariable(value = "book_name") String book_name ) {
        logger.info("BondsApiController::Retrieving bonds for each book");
        List<BondCardDataDto> result = userService.getBondsInSpecificBookForUser(user_id, book_name);
        return ResponseEntity.ok().body(result);

    }


}
