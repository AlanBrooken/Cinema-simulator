package org.hibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernateProject.dao.*;
import org.hibernateProject.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Set;

public class Main {
    private final SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public Main() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        Main main = new Main();
        //main.customerReturnInventoryToStore();

        //Customer customer = main.createCustomer();
        //main.CustomerRentInventory(customer);
        main.newFilmIsAvailable();
    }

    private void newFilmIsAvailable() {
        try(Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Language language = languageDAO.getItems(0, 5).stream().unordered().findAny().get();
            List<Category> categories = categoryDAO.getItems(0, 5);
            List<Actor> actors = actorDAO.getItems(0, 20);

            Film film = new Film();
            film.setTitle("Brooklyn Cowboys 2");
            film.setRating(Rating.PG);
            film.setActors(actors);
            film.setCategories(categories);
            film.setSpecialFeatures(Set.of(Feature.Behind_the_Scenes));
            film.setLanguage(language);
            film.setLength((short)123);
            film.setDescription("Cool story again");
            film.setRentalDuration((byte)4);
            film.setReleaseYear(Year.now());
            film.setRentalRate(BigDecimal.ZERO);
            film.setReplacementCost(BigDecimal.TEN);
            filmDAO.save(film);

            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setId(film.getId());
            filmText.setTitle("Brooklyn Cowboys");
            filmText.setDescription("A new story about all-loved cowboys");
            filmTextDAO.save(filmText);

            session.getTransaction().commit();
        }
    }

    private Customer createCustomer() {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Store store = storeDAO.getItems(0, 1).get(0);

            City city = cityDAO.getByName("London");

            Address address = new Address();
            address.setAddress("Kirova str, 52");
            address.setDistrict("Polsky");
            address.setCity(city);
            address.setPhone("999-890-55-77");
            addressDAO.save(address);

            Customer customer = new Customer();
            customer.setStore(store);
            customer.setFirstName("Nikita");
            customer.setLastName("Bogrov");
            customer.setAddress(address);
            customer.setActive(true);
            customerDAO.save(customer);

            session.getTransaction().commit();
            return customer;
        }
    }
    private void CustomerRentInventory(Customer customer) {
        try (Session session = getSessionFactory().getCurrentSession()){
            session.beginTransaction();

            Film film = filmDAO.getFirstAvailableFilm();
            Store store = storeDAO.getItems(0, 1).get(0);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setAmount(BigDecimal.valueOf(2.99));
            payment.setPaymentDate(LocalDateTime.now());
            paymentDAO.save(payment);

            session.getTransaction().commit();
        }
    }


    private void customerReturnInventoryToStore() {
        try (Session session = getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            Rental rental = rentalDAO.getAnyUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.save(rental);

            session.getTransaction().commit();
        }
    }
}
