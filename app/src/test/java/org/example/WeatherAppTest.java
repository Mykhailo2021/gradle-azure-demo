package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherAppTest {

    @Mock
    private WeatherService weatherService;

    private WeatherApp weatherApp;

    @BeforeEach
    void setUp() {
        // Initialize the WeatherApp with the mocked WeatherService before each test
        weatherApp = new WeatherApp(weatherService);
    }

    @Test
    void shouldReturnSunnyGreetingForNewYork() {
        // Arrange
        when(weatherService.getCurrentWeather("New York")).thenReturn("sunny");

        // Act
        String greeting = weatherApp.getWeatherGreeting("New York");

        // Assert
        assertEquals("Hello! The current weather in New York is sunny", greeting);
    }

    @Test
    void shouldReturnRainyGreetingForDublin() {
        // Arrange
        when(weatherService.getCurrentWeather("Dublin")).thenReturn("rainy");

        // Act
        String greeting = weatherApp.getWeatherGreeting("Dublin");

        // Assert
        assertEquals("Hello! The current weather in Dublin is rainy", greeting);
    }
}


