package projekti;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(DefaultController.class)
public class DefaultControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void requestProtectedResourceRequiresAuthentication() throws Exception {
        mvc.perform(get("/")).andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(value = "ukko")
    public void requestProtectedResourceWithUser() throws Exception {
        mvc.perform(get("/")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }
}
