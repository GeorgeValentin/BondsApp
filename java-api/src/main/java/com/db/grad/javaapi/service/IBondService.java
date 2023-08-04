package com.db.grad.javaapi.service;

import com.db.grad.javaapi.dtos.BondCardDataDto;
import com.db.grad.javaapi.model.Bond;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBondService {
    public List<BondCardDataDto> getAllBonds();
    List<Bond> getActiveBonds();

    List<Bond> getInactiveBonds();

    List<BondCardDataDto> getBondsInMaturityTimeframe();

    public Bond addBond(Bond bond);

    public long getNoOfBonds();

//    public boolean removeBond(long uniqueId);
//
//    public Bond getBondById(long uniqueId);
//
//    public Bond getBondByName(String bondName);
//
//    public Bond updateBondDetails(Bond bondToUpdate);
}

//package com.db.grad.javaapi.service;
//
//import com.db.grad.javaapi.model.Book;
//
//import java.util.List;
//
//public interface IDogsService
//{
//    public List<Book> getAllDogs();
//
//    public Book addDog(Book theDog);
//
//    public long getNoOfDogs();
//
//    public boolean removeDog(long uniqueId);
//
//    public Book getDogById(long uniqueId);
//
//    public Book getDogByName(String dogsName );
//
//    public Book updateDogDetails(Book dogToUpdate);
//}
