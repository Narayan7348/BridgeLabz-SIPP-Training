/*
CLASS Book
    FIELDS
        title, author, year, rating
    
    GETTERS AND SETTERS

CLASS Library
    PRIVATE FIELD
        List<Book> books
    
    METHOD filterBooks()
        RETURN books.stream()
            .filter(book -> book.getYear() > 2015)
            .filter(book -> book.getRating() > 4.5)
            .collect(toList())
    
    METHOD displayFilteredBooks()
        GET filtered books
        FORMAT and display results
*/