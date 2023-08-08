package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.*;
import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BondServiceTest {

    private Bond bond;

    private Client client;

    private Issuer issuer;

//    private BondCardDataDto bondDto;

    @InjectMocks
    public BondService bondservice;

    @Mock
    private BondsRepository bondsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = formatter.parse("2023-08-05");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        issuer = new Issuer(1, "BNPParibasIssu 4,37% Microsoft Corp (USD)");
        client = new Client(1,"AZ Holdings Inc", issuer);
        bond = new Bond(1,"22331122", "XS1988387210" , date, true, client);
        bondDto = new BondCardDataDto(bond);
    }

    @Test
    void getAllBonds() {
        List<Bond> bondCardDataDtos = new ArrayList<>();
        bondCardDataDtos.add(bond);
        when(bondsRepository.findAll()).thenReturn(bondCardDataDtos);

        List<BondCardDataDto> actualResult = bondservice.getAllBonds();

        assertEquals(bondCardDataDtos.get(0), actualResult.get(0));

    }

    @Test
    void getActiveBonds() {
    }

    @Test
    void getInactiveBonds() {
    }

    @Test
    void getBondsInMaturityTimeframe() {
    }

    @Test
    void getBondsById() {
    }
}