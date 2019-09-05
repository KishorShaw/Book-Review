package com.example.JsonInsert;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JsonInsertApplication.class)
@ActiveProfiles("test")
public class JsonInsertApplicationTests {

	@Autowired
	WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void initTests() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context).build();

	}

	public static final String TITLE = "Java book";

	@Test
	public void getDetailsbyTitleTest() throws Exception {

		mvc.perform(get("/book/getBook").param("title", TITLE).accept(MediaType.ALL_VALUE)).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[0].title", is("Java book"))).andExpect(jsonPath("$.[0].author", is("Ronald")))
				.andExpect(jsonPath("$.[0].publishedDate", is("2019-02-01")))
				.andExpect(jsonPath("$.[0].isbn", is(857300923712L)))
				.andExpect(jsonPath("$.[0].reviews.[0].reviewerName", is("Johnson")))
				.andExpect(jsonPath("$.[0].reviews.[0].content", is("Books for advance programmer")))
				.andExpect(jsonPath("$.[0].reviews.[0].rating", is("3.0")))
				.andExpect(jsonPath("$.[0].reviews.[0].publishedDate", is("2019-03-02")))
				.andExpect(jsonPath("$.[0].reviews.[1].reviewerName", is("Mike")))
				.andExpect(jsonPath("$.[0].reviews.[1].content", is("Nice topics")))
				.andExpect(jsonPath("$.[0].reviews.[1].rating", is("4.5")));

	}

}
