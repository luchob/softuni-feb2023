package bg.softuni.security.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerIT {

  @Autowired
  MockMvc mockMvc;

  @Test
  void testRegisterView() throws Exception {

    mockMvc.perform(
        MockMvcRequestBuilders.
            get("/users/register")
    ).andExpect(
        status().isOk()
    ).andExpect(
        view().name("auth-register")
    );

  }

}
