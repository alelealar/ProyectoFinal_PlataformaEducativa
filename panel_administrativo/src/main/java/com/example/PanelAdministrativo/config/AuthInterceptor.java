package com.example.PanelAdministrativo.config;

import com.example.PanelAdministrativo.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    public static final String SESSION_USUARIO_ID = "usuario_id";
    public static final String SESSION_USUARIO_ROL = "usuario_rol";
    public static final String SESSION_USUARIO_NOMBRE = "usuario_nombre";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);

        if (!tieneSesionAdministrador(session)) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

    public static boolean tieneSesionAdministrador(HttpSession session) {
        if (session == null) {
            return false;
        }
        Object id = session.getAttribute(SESSION_USUARIO_ID);
        Object rol = session.getAttribute(SESSION_USUARIO_ROL);
        return id != null && UsuarioService.ROL_ADMIN.equalsIgnoreCase(String.valueOf(rol));
    }
}
