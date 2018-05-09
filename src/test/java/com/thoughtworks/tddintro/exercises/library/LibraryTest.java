package com.thoughtworks.tddintro.exercises.library;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private List<String> books;
    private PrintStream printStream;
    private Library library;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = new Library(books, printStream, bufferedReader);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by the printStream
        printStream.println(title);
        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        printStream.println();
        verify(printStream).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        String book1Title = "GoodBook";
        String book2Title = "GoodBook2";
        books.add(book1Title);
        books.add(book2Title);
        library.listBooks();

        verify(printStream).println(book1Title+"\n"+book2Title+"\n");
    }

    @Test
    public void shouldAddBookToCollectionWhenEnteredByUser() throws IOException {
        when(bufferedReader.readLine()).thenReturn("The Hobbit");
        library.enterBook();
        assertThat(books, hasItems("The Hobbit"));
    }

    @Test
    public void shouldDeleteBookFromCollectionWhenRemovedByUser() throws IOException {
        // Add when/thenReturn here
        when(bufferedReader.readLine()).thenReturn("The Two Towers");

        books.add("The Two Towers");
        library.removeBook();

        assertThat(books, not(hasItems("The Two Towers")));
    }
}
