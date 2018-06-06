package com.jeyson.springboot;

import com.alibaba.fastjson.JSON;
import com.jeyson.springboot.dao.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: liujishuai
 * @Time: 2018/3/1 10:24
 * @Description: mockmvc接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
@WebAppConfiguration
public class TestUserController {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mock;
    @Before
    public  void setUp(){
        mock = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testMockParam(){
        try {
            mock.perform(
                    MockMvcRequestBuilders.get("/hello")
                            .param("param","jeyson")

            )
                    .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMockJSON(){
        User user=new User();
        user.setUsername("jeyson");
        user.setAccount("jeyson@163.com");
        user.setPassword("123");
        try {
            mock.perform(
                    MockMvcRequestBuilders.post("/helloJson")
                            .content(JSON.toJSONString(user))
                            .contentType(MediaType.APPLICATION_JSON)
                            .characterEncoding("utf-8")
                            .accept(MediaType.APPLICATION_JSON)

            )
                    .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
