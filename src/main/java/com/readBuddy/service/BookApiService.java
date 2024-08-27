package com.readBuddy.service;

import com.readBuddy.dto.BookApiDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BookApiService {
    @Value("${api.key}")
    private String apiKey;

    public void recommendBook() {
        RestClient restClient = RestClient.create();
        BookApiDto recomBook = restClient.post()
                .uri("https://nl.go.kr/NL/search/openApi/saseoApi.do")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(BookApiDto.class);
    }

}
