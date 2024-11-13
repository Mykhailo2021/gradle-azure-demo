package org.example;

public class WeatherApp {
    private final WeatherService weatherService;

    public WeatherApp(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getWeatherGreeting(String city) {
        String weather = weatherService.getCurrentWeather(city);
        return "Hello! The current weather in " + city + " is " + weather;
    }
}