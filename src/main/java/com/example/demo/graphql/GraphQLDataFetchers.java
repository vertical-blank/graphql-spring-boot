package com.example.demo.graphql;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.config.Config;
import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraphQLDataFetchers {

    private Config config;

    private BookDao bookDao;

    private AuthorDao authorDao;

    @Autowired
    public GraphQLDataFetchers(Config config, BookDao bookDao, AuthorDao authorDao) {
        this.config = config;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"),
            ImmutableMap.of("id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice")
    );

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            int bookId = dataFetchingEnvironment.getArgument("id");
            return config.getTransactionManager().required(() ->
                bookDao.findById(bookId)
            );
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            int authorId = book.getAuthorId();
            return config.getTransactionManager().required(() ->
                    authorDao.findById(authorId)
            );
        };
    }
}
