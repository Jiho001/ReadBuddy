package com.readBuddy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    public String recommendBook(String jenre) throws JsonProcessingException {
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

        // 어케<list> - <item> - <recomtitle>, <recomauthor>, <recomfilepath>, <recomcontens> 들을 리스트로 만들어서 반환하지????
        return xml2Json(response);
    }

    private String xml2Json(String xml) {

        JSONObject json = XML.toJSONObject(xml);
        String jsonStr = json.toString(4);
        return jsonStr;
    }

//    private String json2resp(String jsonStr) {
//
//    }
}
