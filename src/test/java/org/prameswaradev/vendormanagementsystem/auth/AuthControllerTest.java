package org.prameswaradev.vendormanagementsystem.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoginSuccessful() throws Exception {
        // JSON payload for login
        String loginRequestJson = "{\"username\":\"siti@example.com\",\"password\":\"password123\"}";

        // Perform the request and verify the response
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginRequestJson))  // Correct method to add content (payload)
                .andExpect(status().isOk());
    }

//    @Test
//    public void testRateLimiterExceeded() throws Exception {
//        String loginRequestJson = "{\"username\":\"siti@example.com\",\"password\":\"password123\"}";
//
//        // Send requests until the rate limiter exceeds (adjust based on the rate limit)
//        for (int i = 0; i < 5; i++) {
//            mockMvc.perform(post("/auth/login")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(loginRequestJson))
//                    .andExpect(status().isOk());
//        }
//
//        mockMvc.perform(post("/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(loginRequestJson))
//                .andExpect(status().isTooManyRequests());
//    }
}