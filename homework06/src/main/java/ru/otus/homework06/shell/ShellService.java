package ru.otus.homework06.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.homework06.Exception.EmptyFieldException;
import ru.otus.homework06.service.BookService;
import ru.otus.homework06.service.IOService;

@ShellComponent
public class ShellService {
    private final IOService ioService;
    private final BookService bookService;

    @Autowired
    public ShellService(BookService bookService, IOService ioService) {
        this.bookService = bookService;
        this.ioService = ioService;
    }

    @ShellMethod(key = {"add"}, value = "add book to library")
    @Transactional
    public void addBook() throws EmptyFieldException {
        bookService.insert(bookService.getNewBook());
    }

    @ShellMethod(key = {"get_id"}, value = "get book by Id")
    public void getBookById() {
        ioService.write(bookService.getById(ioService.readInt()));
    }

    @ShellMethod(key = {"all"}, value = "show all books")
    public void allBooks() {
        bookService.getAll().forEach(ioService::write);
    }

    @ShellMethod(key = "count", value = "count of all books")
    public void bookCount() {
        ioService.write(bookService.getCount());
    }

    @ShellMethod(key = {"del_id"}, value = "delete book by Id")
    @Transactional
    public void deleteBookById() {
        bookService.deleteById(ioService.readInt());
    }

    @ShellMethod(key = {"get_a"}, value = "get books by Author")
    public void getBooksByAuthor() throws EmptyFieldException {
        bookService.findByAuthorName(ioService.read()).forEach(ioService::write);
    }

}
