package com.convergence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
// 将是WebApplicationContext 类型的
@WebAppConfiguration // 测试环境使用，用来表示测试环境使用的 ApplicationContext
public class ConvergenceApplicationTests {
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		// 通过 MockMvcBuilders.xxxSetup().build() 创建一个 MockMvc 进行测试；
		// mvc = MockMvcBuilders.standaloneSetup(new XXController()).build();
	}

	@Test
	public void getHello() throws Exception {
		// mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		// .andExpect(content().string(equalTo("hello
		// world!"))).andDo(MockMvcResultHandlers.print()).andReturn();
	}
    /**
     * 1、mockMvc.perform 执行一个请求。
     * 2、MockMvcRequestBuilders.get("XXX") 构造一个请求。
     * 3、ResultActions.andExpect 添加执行完成后的断言。
     * 4、ResultActions.andDo 添加一个结果处理器，表示要对结果做点什么事情
     *   比如此处使用 MockMvcResultHandlers.print() 输出整个响应结果信息。
     * 5、ResultActions.andReturn 表示执行完成后返回相应的结果。
     */
	@Test
	public void contextLoads() {
	}

}
