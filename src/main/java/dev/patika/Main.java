package dev.patika;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Author author = new Author();
        author.setName("J.R.R TOLKIEN");
        author.setBirthDate(LocalDate.now());
        author.setCountry("England");
        entityManager.persist(author);

        Publisher publisher= new Publisher();
        publisher.setName("Metis Yayınları");
        publisher.setAddress("İstanbul");
        publisher.setEstablishmentYear(1998);
        entityManager.persist(publisher);

        Book book = new Book();
        book.setName("Lord Of The Rings: The Fellowship of the Ring");
        book.setStock(20);
        book.setPublicationYear(1954);
        book.setAuthor(author);
        book.setPublisher(publisher);
        entityManager.persist(book);

        Category category = new Category();
        category.setDescription("Masterpiece");
        category.setName("Best Sellers");
        entityManager.persist(category);

        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Ali Batuhan ŞAHİN");
        bookBorrowing.setBook(book);
        bookBorrowing.setBorrowingDate(LocalDate.now());
        bookBorrowing.setReturnDate(LocalDate.now());
        entityManager.persist(bookBorrowing);

        Book bookcat = entityManager.find(Book.class,book.getId());
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        bookcat.setCategories(categories);


        transaction.commit();
    }
}