package com.alex.springDemo.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alex.springDemo.domain.Author;
import com.alex.springDemo.domain.Book;
import com.alex.springDemo.domain.Publisher;
import com.alex.springDemo.repositories.AuthorRepository;
import com.alex.springDemo.repositories.BookRepository;
import com.alex.springDemo.repositories.PublisherRepository;


//import org.springframework.*;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started in Bootstrap\n");
		
		Publisher publisher = new Publisher();
		publisher.setName("Publisher Example");
		publisher.setCity("Houston");
		publisher.setState("Texas");
		
		publisherRepository.save(publisher);
		
		System.out.println("Publisher count: " + publisherRepository.count());
		
		Author kv = new Author("Kurt", "Vonnegut");
		Book cc = new Book("Cat's Cradle", "312312");
		
		kv.getBooks().add(cc);
		cc.getAuthors().add(kv);
		
		cc.setPublisher(publisher);
		publisher.getBooks().add(cc);
		
		
		authorRepository.save(kv);
		bookRepository.save(cc);
		publisherRepository.save(publisher);
		
		Author ag = new Author("Allen","Ginsberg");
		Book h = new Book("Howl","000001");
		 
		ag.getBooks().add(h);
		h.getAuthors().add(ag);
		
		h.setPublisher(publisher);
		publisher.getBooks().add(h);
		
		authorRepository.save(ag);
		bookRepository.save(h);
		publisherRepository.save(publisher);
		
		Author wg = new Author("William","Gibson");
		Book n = new Book("Neuromancer","0441569560");
		
		wg.getBooks().add(n);
		n.getAuthors().add(wg);
		
		n.setPublisher(publisher);
		publisher.getBooks().add(n);
		
		authorRepository.save(wg);
		bookRepository.save(n);
		publisherRepository.save(publisher);

		System.out.println("\nNumber of books: " + bookRepository.count());
		System.out.println("\nNumber of books: " + publisher.getBooks().size());
	}
}
