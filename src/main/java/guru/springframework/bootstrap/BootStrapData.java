package guru.springframework.bootstrap;

import guru.springframework.model.Author;
import guru.springframework.model.Book;
import guru.springframework.model.Publisher;
import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.BookRepository;
import guru.springframework.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "12121212");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","4641326544");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        Publisher publisher = new Publisher("Pub1", "Add1", "C1", "S1", "Z1");

        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);

        ddd.setPublisher(publisher);
        noEJB.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

    }
}
