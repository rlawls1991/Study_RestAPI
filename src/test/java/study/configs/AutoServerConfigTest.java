package study.configs;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import study.common.BaseControllerTest;
import study.config.AppProperties;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AutoServerConfigTest extends BaseControllerTest {

    @Autowired
    AppProperties appProperties;

    @Test
    @DisplayName("인증 토큰을 발급 받는 테스트")
    public void getAuthToken() throws Exception {
        this.mockMvc.perform(post("/oauth/token")
                .with(httpBasic(appProperties.getClientId(), appProperties.getClientSecret()))
                .param("username", appProperties.getUserUserName())
                .param("password", appProperties.getUserPassword())
                .param("grant_type", "password"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("access_token").exists());
    }
}
