package com.namratha.vancouverexplorer.ai;

import com.namratha.vancouverexplorer.graphql.ExplorerQuery;
import dev.langchain4j.exception.RateLimitException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExplorerQueryTest {
    @Test
    void exploreVancouver_WhenRateLimited_ReturnsFallbackMessage() {
        //Arrange
        //mock explorerAssisstant
        ExplorerAssistant mockExplorerAssisstant = Mockito.mock(ExplorerAssistant.class);

        Mockito.when(mockExplorerAssisstant.explore("Find outdoor places.")).thenThrow(RateLimitException.class);

        //Act
        //we are testing ExplorerQuery's exploreVancouver method
        ExplorerQuery explorerQuery = new ExplorerQuery(mockExplorerAssisstant);
        String actualResult = explorerQuery.exploreVancouver("Find outdoor places.");

        //Assert
        assertEquals("Our AI assistant is temporarily unavailable due to high demand. Please try again later.", actualResult);
    }

    @Test
    void exploreVancouver_WhenSuccessful_ReturnsCorrectResponse() {
        //Arrange
        ExplorerAssistant mockExplorerAssisstant = Mockito.mock(ExplorerAssistant.class);
        Mockito.when(mockExplorerAssisstant.explore("Find outdoor places.")).thenReturn("Stanley Park is a great outdoor destination.");

        //Act
        ExplorerQuery explorerQuery = new ExplorerQuery(mockExplorerAssisstant);
        String actualResult = explorerQuery.exploreVancouver("Find outdoor places.");

        //Assert
        assertEquals("Stanley Park is a great outdoor destination.", actualResult);
    }

}
