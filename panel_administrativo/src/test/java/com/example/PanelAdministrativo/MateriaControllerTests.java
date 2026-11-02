package com.example.PanelAdministrativo;

import com.example.PanelAdministrativo.config.AuthInterceptor;
import com.example.PanelAdministrativo.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class MateriaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void renderizaGestionDeMateriasParaAdministrador() throws Exception {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(AuthInterceptor.SESSION_USUARIO_ID, 1L);
        session.setAttribute(AuthInterceptor.SESSION_USUARIO_ROL, UsuarioService.ROL_ADMIN);

        mockMvc.perform(get("/gestion-materias").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("gestion-materias"))
                .andExpect(content().string(containsString("Gestión de materias y cupos")));
    }
}
