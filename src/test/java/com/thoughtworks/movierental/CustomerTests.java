package com.thoughtworks.movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("Generate Statement when 1 0r more movie rented.")
    public void GenerateStatement_When1orMoreMovie_ShouldReturnStatement() {
        //Arrange
        String name = "CodeWorkshop";
        Customer customer = new Customer(name);
        Movie movie = new Movie("Brahmastra:Part One", Movie.NEW_RELEASE);
        /*TODO: Array of movie*/
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);
        /*ACT*/
        String statement = customer.statement();
        //Assert
        Assertions.assertTrue(!statement.isEmpty());
        //Check if the name is present
        Assertions.assertTrue(statement.contains(name));
        Assertions.assertEquals("Rental Record for CodeWorkshop\n" +
                "\tBrahmastra:Part One\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", statement);

    }
}