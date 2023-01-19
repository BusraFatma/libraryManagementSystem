package com.lms.lms.services;

import com.lms.lms.data.models.Author;
import com.lms.lms.data.models.Book;
import com.lms.lms.data.repositories.BookRepository;
import com.lms.lms.dtos.request.CreateAuthorRequest;
import com.lms.lms.dtos.request.CreateBookRequest;
import com.lms.lms.dtos.request.UpdateAuthorRequest;
import com.lms.lms.dtos.response.CreateBookResponse;
import com.lms.lms.exceptions.BookException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CreateBookResponse createBook(CreateBookRequest createBookRequest) {
        if (bookRepository.findBookByIsbn(createBookRequest.getIsbn()).isPresent())throw new BookException("Book already exist");
//        Book book = Book.builder().
//                bookName(createBookRequest.getBookName()).
//                quantity(createBookRequest.getQuantity()).
//                yearPublished(createBookRequest.getYearPublished()).
//                authors()
//        Author bookAuthor = authorService.getAuthorById(createBookRequest.getAuthorId());
        List<Author> foundAuthors = authorService.getAllAuthorsById(createBookRequest.getAuthorIds());
        Book book = new Book();
        book.setBookName(createBookRequest.getBookName());
        book.setIsbn(createBookRequest.getIsbn());
        book.setQuantity(createBookRequest.getQuantity());
        book.setYearPublished(createBookRequest.getYearPublished());

        Book savedBook = bookRepository.save(book);

//        book.getAuthors().add(bookAuthor);
        for (int i = 0; i < foundAuthors.size(); i++) {
            Author author =   authorService.getAuthorById(foundAuthors.get(i).getId());

//            Book savedBook = bookRepository.save(book);
            Author authorByEmail = authorService.getAuthorByEmail(author.getEmail());
            UpdateAuthorRequest updateAuthorRequest = new UpdateAuthorRequest();
            updateAuthorRequest.setBook(savedBook);

            updateAuthorRequest.setEmail(authorByEmail.getEmail());
//            updateAuthorRequest.setId(authorByEmail.getId());


            authorService.updateAuthorByEmail(updateAuthorRequest);
            book.getAuthors().add(authorByEmail);
//            author.getBooks().add(book);

        }


        CreateBookResponse createBookResponse = new CreateBookResponse();
        return createBookResponse;
//
//        return modelMapper.map(savedBook, CreateBookResponse.class);
//        if (bookRepository.findBookByIsbn(createBookRequest.getIsbn()).isPresent())throw new BookException("Book already exist");
//        Book book = new Book();
//        book.setBookName(createBookRequest.getBookName());
//        book.setIsbn(createBookRequest.getIsbn());
//        book.setYearPublished(createBookRequest.getYearPublished());
//        book.setQuantity(createBookRequest.getQuantity());
//        book.setAuthors(createBookRequest.getAuthors());
//        if (bookRepository.findBookByIsbn(createBookRequest.getBook().getIsbn()).isPresent())throw new BookException("Book already exist");
//        Book book = new Book();
//        book.setBookName(createBookRequest.getBook().getBookName());
//        book.setIsbn(createBookRequest.getBook().getIsbn());
//        book.setQuantity(createBookRequest.getBook().getQuantity());
//        book.setYearPublished(createBookRequest.getBook().getYearPublished());
//        book.setAuthors(createBookRequest.getBook().getAuthors());
//        System.out.println(createBookRequest);
//        Book savedBook = bookRepository.save(book);
//
//
//        for (int i = 0; i < createBookRequest.getBook().getAuthors().size(); i++) {
//            Author findAuthor = authorService.getAuthorByEmail(createBookRequest.getBook().getAuthors().get(i).getEmail());
//            if(findAuthor==null){
//                CreateAuthorRequest createAuthorRequest = new CreateAuthorRequest();
//                createAuthorRequest.setEmail(createBookRequest.getBook().getAuthors().get(i).getEmail());
//                createAuthorRequest.setFirstName(createBookRequest.getBook().getAuthors().get(i).getFirstName());
//                createAuthorRequest.setLastName(createBookRequest.getBook().getAuthors().get(i).getLastName());
//                authorService.createAuthor(createAuthorRequest);
//            }
//
//        }
//
//        for (int i = 0; i < createBookRequest.getBook().getAuthors().size(); i++) {
//            UpdateAuthorRequest updateAuthorRequest = new UpdateAuthorRequest();
//            updateAuthorRequest.setId(createBookRequest.getBook().getAuthors().get(i).getId());
//            updateAuthorRequest.setBook(savedBook);
//            authorService.updateAuthorByEmail(updateAuthorRequest);
//        }
//
////        CreateBookResponse createBookResponse = new CreateBookResponse();
//        return modelMapper.map(savedBook, CreateBookResponse.class);

    }

    @Override
    public String deleteBookById() {
        return null;
    }

    @Override
    public String deleteAllBooks() {
        return null;
    }

    @Override
    public String deleteBookByIsbn() {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public Book getBookByIsbn(Long isbn) {
        return bookRepository.findBookByIsbn(isbn).orElseThrow(()->new BookException("Book does not exist"));
    }

    @Override
    public Book getBookByName(String bookName) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName) {
        return null;
    }

    @Override
    public List<Book> getListOfBooksByAuthors(Long authorId) {
        List<Book> books = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for(Book book: bookList){
            for(int i = 0; i<book.getAuthors().size(); i++){
                if (book.getAuthors().get(i).getId().equals(authorId)) books.add(book);
            }
        }

        return books;
    }

    @Override
    public void deleteAll() {

    }
//    @Override
//    public CreateBookResponse saveBook(CreateBookRequest createBookRequest) {
//        if (bookRepository.findBookByIsbn(createBookRequest.getIsbn()).isPresent())throw new BookException("Book already exist");
//        Author foundAuthor = authorService.findAuthorById(createBookRequest.getAuthorId());
//    }


}
