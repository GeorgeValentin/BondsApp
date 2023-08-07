package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BondsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BondServiceTest {

    private Bond bond;

    private BondCardDataDto bondDto;

    @InjectMocks
    public BondService bondservice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        bond = new Bond(1, '22331122', 'XS1988387210' , '2023-08-05', true);
        bondDto = new BondCardDataDto(1, '22331122', 'XS1988387210', '2023-08-05')
    }

    @Mock
    private BondsRepository bondsRepository;

    @Test
    void getAllBonds() {
        List<BondCardDataDto> bondCardDataDtos = new ArrayList<>();
        bondCardDataDtos.add(bondDto);
        when(bondservice.find();
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