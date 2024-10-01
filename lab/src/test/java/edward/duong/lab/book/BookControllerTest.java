package edward.duong.lab.book;

import edward.duong.lab.service.DefaultBookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class BookControllerTest extends AbstractControllerTest {

    @Autowired
    DefaultBookService bookService;

    @Test
    @DisplayName("Get books should success")
    void shouldReturnDefaultMessage() throws Exception {
        mockMvc
                .perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(bookService.getBooks())));
    }

}
