package com.example.taco;

import com.example.taco.controler.HomeCotroler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeCotroler.class) // Popraw nazwę klasy kontrolera
public class HomeControllerTest { // Zaktualizuj nazwę klasy testowej, jeśli to konieczne

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/d")) // Upewnij się, że ścieżka "/d" jest obsługiwana przez kontroler
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Home"))); // Użyj containsString dla zawartości, jeśli oczekujesz, że "Home" będzie częścią większej odpowiedzi
    }
}