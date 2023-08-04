package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BondsApiController {

    public static final Logger logger = LogManager.getLogger(BondsApiController.class);

    @Autowired
    private BondService bondService;

    @GetMapping("/activeBonds")
    public ResponseEntity<List<Bond>> getActiveBonds() {
        return ResponseEntity.ok().body(bondService.getActiveBonds());
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

    @GetMapping("/bonds/maturity")
    public ResponseEntity<List<BondCardDataDto>> getBondsInMaturityTimeframe() {
        logger.info("BondsApiController::Retrieving bonds in the default maturity timeframe.");
        return ResponseEntity.ok().body(bondService.getBondsInMaturityTimeframe());
    }
}
