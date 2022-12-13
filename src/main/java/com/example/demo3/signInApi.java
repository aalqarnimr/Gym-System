package com.example.demo3;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.HashMap;
import java.util.Map;

public class signInApi {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://us-central1-swe206-221.cloudfunctions.net/app/SignIn?teamKey=99345103&username=Ahmad&password=124578"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }


}
