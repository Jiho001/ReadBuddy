package com.readBuddy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.readBuddy.dto.BookApiDto;
import org.json.XML;
import org.json.JSONObject;
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

    public BookApiDto recommendBook(String jenre) throws JsonProcessingException {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://nl.go.kr/NL/search/openApi/saseoApi.do")
                .build();

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("key", apiKey);
        formData.add("drCode", jenre);
        formData.add("endRowNumApi", "5");  // 추천 권수

        String response = restClient.post()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(formData)
                .retrieve()
                .body(String.class);

        String jsonStr = xml2Json(response);

        return json2dto(jsonStr);
    }

    // xml -> JSON
    private String xml2Json(String xml) {

        JSONObject json = XML.toJSONObject(xml);
        String jsonStr = json.toString(4);
        return jsonStr;
    }

    // json 파싱
    private BookApiDto json2dto(String jsonStr) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        BookApiDto dto = objectMapper.readValue(jsonStr, BookApiDto.class);
        return dto;
    }
}
