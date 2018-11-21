package com.rhythm.warn.web;

import com.alibaba.fastjson.JSONObject;
import com.rhythm.warn.WarnServiceApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.Cookie;

/**
 * 单元测试
 *
 * @author majunjie
 * @date 2018/11/19 13:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WarnServiceApplication.class)
@AutoConfigureMockMvc
public class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    Cookie[] cookies;

    @Before
    public void genCookie() {
        cookies = new Cookie[2];
        cookies[0] = new Cookie("SESSION", "e0268786-45a8-454b-a62e-f7d98cc909dc");
        cookies[1] = new Cookie("JSESSIONID", "544E5EDEB350424BEC6F6BF332C5F602");
    }

    @Test
    public void createOrder() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/heartbeat"
        ).cookie(cookies)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString("{}"));
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

}
