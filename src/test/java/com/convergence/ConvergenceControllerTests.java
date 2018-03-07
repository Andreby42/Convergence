package com.convergence;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = MockServletContext.class)
public class ConvergenceControllerTests {
    @Value("${local.server.port}")
    private int port;
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    // demo
    // @Test
    // public void webappBookIsbnApi() {
    // Book book = restTemplate.getForObject("http://localhost:" + port +
    // "/books/9876-5432-1111", Book.class);
    // assertNotNull(book);
    // assertEquals("中文测试", book.getPublisher().getName());
    // }
    //
    // @Test
    // public void webappPublisherApi() throws Exception {
    // // MockHttpServletRequestBuilder.accept方法是设置客户端可识别的内容类型
    // //
    // MockHttpServletRequestBuilder.contentType,设置请求头中的Content-Type字段,表示请求体的内容类型
    // mockMvc.perform(get("/publishers/1").accept(MediaType.APPLICATION_JSON_UTF8))
    //
    // .andExpect(status().isOk()).andExpect(content().string(containsString("中文测试")))
    // .andExpect(jsonPath("$.name").value("中文测试"));
    // }

}
