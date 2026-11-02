package com.example.PanelAdministrativo.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtils {

    public static String hashContraseña(String contraseña) {
        return BCrypt.hashpw(contraseña, BCrypt.gensalt(12));
    }

    public static boolean verificarContraseña(String contraseña, String contraseñaHash) {
        return BCrypt.checkpw(contraseña, contraseñaHash);
    }

}
