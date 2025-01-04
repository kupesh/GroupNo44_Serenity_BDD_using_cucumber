package com.example.serenity.apitesting.config;

public class Constants {
    public static final String BASE_URI = ConfigLoader.getProperty("base.uri");
    public static final String ADMIN_USERNAME = ConfigLoader.getProperty("admin.username");
    public static final String ADMIN_PASSWORD = ConfigLoader.getProperty("admin.password");
    public static final String USER_USERNAME = ConfigLoader.getProperty("user.username");
    public static final String USER_PASSWORD = ConfigLoader.getProperty("user.password");

    // API Endpoints
    public static final String BOOKS_ENDPOINT = ConfigLoader.getProperty("books.endpoint");
}

