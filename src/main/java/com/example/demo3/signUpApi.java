package com.example.demo3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class signUpApi {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://us-central1-swe206-221.cloudfunctions.net/app/SignUp?teamKey=99345103"))
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\n\n    \"username\":\"Ahmad\",\n\n    \"password\":\"124578\",\n\n    \"type\":\"trainer\"\n\n}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
