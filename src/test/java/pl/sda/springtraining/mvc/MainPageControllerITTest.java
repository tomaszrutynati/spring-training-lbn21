package pl.sda.springtraining.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.sda.springtraining.config.FacilityConfiguration;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainPageControllerITTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FacilityConfiguration facilityConfiguration;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void shouldDisplayMainPage() throws Exception {
        //when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/"));
        //then
        result.andExpect(model().attributeExists("date"))
                .andExpect(model().attribute("config", facilityConfiguration))
                .andExpect(content().string(containsString("Pracujemy od")))
                .andExpect(status().is2xxSuccessful());
    }
}
