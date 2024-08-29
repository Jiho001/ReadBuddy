package com.readBuddy.service;

import com.readBuddy.dto.BookApiDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

@Service
public class BookApiService {
    @Value("${api.key}")
    private String apiKey;

    public String recommendBook() {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://nl.go.kr/NL/search/openApi/saseoApi.do")
                .build();

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("key", apiKey);
        formData.add("drCode", "11");

        String response = restClient.post()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(formData)
                .retrieve()
                .body(String.class);

        return response;
    }
}
