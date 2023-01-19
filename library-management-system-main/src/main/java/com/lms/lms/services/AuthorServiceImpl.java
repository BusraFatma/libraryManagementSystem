package com.lms.lms.services;

import com.lms.lms.data.models.Author;
import com.lms.lms.data.repositories.AuthorRepository;
import com.lms.lms.dtos.request.CreateAuthorRequest;
import com.lms.lms.dtos.request.UpdateAuthorRequest;
import com.lms.lms.dtos.response.CreateAuthorResponse;
import com.lms.lms.dtos.response.UpdateAuthorResponse;
import com.lms.lms.exceptions.AuthorException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CreateAuthorResponse createAuthor(CreateAuthorRequest createAuthorRequest) {
        if (authorRepository.findAuthorByEmail(createAuthorRequest.getEmail().toLowerCase()) != null) throw new AuthorException("exists");
        Author author = Author.builder().
                email(createAuthorRequest.getEmail().toLowerCase()).
                firstName(createAuthorRequest.getFirstName()).
                lastName(createAuthorRequest.getLastName()).build();
//        CreateAuthorResponse createAuthorResponse = new CreateAuthorResponse();
//        for (int i = 0; i < createAuthorRequest.getAuthors().size(); i++) {
//            Author getAuthor = createAuthorRequest.getAuthors().get(i);
//            if (authorRepository.findAuthorByEmail(getAuthor.getEmail().toLowerCase()).isEmpty()){
//                Author author = new Author();
//                author.setEmail(getAuthor.getEmail());
//                author.setFirstName(getAuthor.getFirstName());
//                author.setLastName(getAuthor.getLastName());
//                author.getBooks().add(createAuthorRequest.getBook());
//                authorRepository.save(author);
//                createAuthorResponse.setMessage("Authors Added successfully");
//            }
//        }
//        return createAuthorResponse;
//        Author author = new Author();
//        author.setEmail(createAuthorRequest.getEmail());
//        author.setFirstName(createAuthorRequest.getFirstName());
//        author.setLastName(createAuthorRequest.getLastName());
//        author.getBooks().add(createAuthorRequest.getBook());
        Author savedAuthor = authorRepository.save(author);
        return modelMapper.map(savedAuthor, CreateAuthorResponse.class);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new AuthorException("Author with id "+ id +" does not exist"));
    }

    @Override
    public Author getAuthorByEmail(String email) {
        return authorRepository.findAuthorByEmail(email);
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findAuthorById(id);
    }


    @Override
    public List<Author> getAllAuthorsById(List<Long> ids) {
        return authorRepository.findAllById(ids);
    }

    @Override
    public void deleteAll() {
        authorRepository.deleteAll();
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public String deleteAuthorByEmail(String email) {
        getAuthorByEmail(email);
        authorRepository.deleteAuthorByEmail(email);
        return "Admin deleted successfully";
    }

    @Override
    public UpdateAuthorResponse updateAuthorByEmail(UpdateAuthorRequest updateAuthorRequest) {
        if (authorRepository.findAuthorByEmail(updateAuthorRequest.getEmail()) == null) System.out.println("doesnt exist");
        Author foundAuthor = getAuthorByEmail(updateAuthorRequest.getEmail());
        if (updateAuthorRequest.getFirstName() != null)foundAuthor.setFirstName(updateAuthorRequest.getFirstName());
        if (updateAuthorRequest.getLastName() != null)foundAuthor.setLastName(updateAuthorRequest.getLastName());
        if (updateAuthorRequest.getBook() != null)foundAuthor.getBooks().add(updateAuthorRequest.getBook());
        Author savedAuthor = authorRepository.save(foundAuthor);
        return modelMapper.map(savedAuthor, UpdateAuthorResponse.class);
    }


}
