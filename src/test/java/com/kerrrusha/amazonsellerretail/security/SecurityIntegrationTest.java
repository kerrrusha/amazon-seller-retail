package com.kerrrusha.amazonsellerretail.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith({SpringExtension.class, MockitoExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void authLoginAccess_notAuthorized_ok() throws Exception {
        mockMvc.perform(post("/auth/login"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void authRegisterAccess_notAuthorized_ok() throws Exception {
        mockMvc.perform(post("/auth/register"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void reportTotalByDateAccess_notAuthorized_notOk() throws Exception {
        mockMvc.perform(post("/report/total-by-date"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "someUser")
    void reportTotalByDateAccess_authorized_ok() throws Exception {
        mockMvc.perform(get("/report/total-by-date"))
                .andExpect(status().isOk());
    }
}
