//package com.db.grad.javaapi.service;
//
//import com.db.grad.javaapi.model.Book;
//import com.db.grad.javaapi.repository.DogsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DogHandler implements IDogsService
//{
//    private DogsRepository itsDogsRepo;
//
//    @Autowired
//    public DogHandler( DogsRepository dogRepo )
//    {
//        itsDogsRepo = dogRepo;
//    }
//
//    @Override
//    public List<Book> getAllDogs()
//    {
//        return itsDogsRepo.findAll();
//    }
//
//    @Override
//    public Book addDog(Book theDog)
//    {
//        return itsDogsRepo.save( theDog );
//    }
//
//    @Override
//    public long getNoOfDogs()
//    {
//        return itsDogsRepo.count();
//    }
//
//    @Override
//    public boolean removeDog(long uniqueId)
//    {
//        boolean result = false;
//
//        Optional<Book> theDog = itsDogsRepo.findById(uniqueId);
//        if(theDog.isPresent())
//        {
//            itsDogsRepo.delete(theDog.get());
//            result = true;
//        }
//
//        return  result;
//    }
//
//    @Override
//    public Book getDogById(long uniqueId)
//    {
//        return itsDogsRepo.findById(uniqueId).get();
//    }
//
//    @Override
//    public Book getDogByName(String dogsName )
//    {
//        Book dogToFind = new Book();
//        dogToFind.setName(dogsName);
//        List<Book> dogs = itsDogsRepo.findByName(dogToFind);
//        Book result = null;
//
//        if( dogs.size() == 1)
//            result = dogs.get(0);
//
//        return result;
//    }
//
//    @Override
//    public Book updateDogDetails(Book dogToUpdate)
//    {
//        return itsDogsRepo.save( dogToUpdate );
//    }
//}
