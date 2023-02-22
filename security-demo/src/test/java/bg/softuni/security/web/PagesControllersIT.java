package bg.softuni.security.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PagesControllersIT {

  @Autowired
  MockMvc mockMvc;

  @WithMockUser(
      username = "pesho",
      roles = {"MODERATOR"}
  )
  @Test
  void testModeratorPageView() throws Exception {

    mockMvc.perform(
        MockMvcRequestBuilders.
            get("/pages/moderators")
    ).andExpect(
        status().isOk()
    ).andExpect(
        view().name("moderators")
    );

  }

  @WithMockUser(
      username = "pesho"
  )
  @Test
  void testAllPageView() throws Exception {

    mockMvc.perform(
        MockMvcRequestBuilders.
            get("/pages/all")
    ).andExpect(
        status().isOk()
    ).andExpect(
        view().name("all")
    );

  }

}
