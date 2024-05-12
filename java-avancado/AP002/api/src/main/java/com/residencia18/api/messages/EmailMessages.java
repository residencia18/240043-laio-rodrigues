package com.residencia18.api.messages;

import com.residencia18.api.entity.User;

public class EmailMessages {
    public static final String RECOVERY_TITLE = "Solicitação de redefinição de senha!";

    public static String messageToRecovery(User user, String link){
        return
            "<div>Olá " + user.getUsername() + "! Sua solicitação de recuperação de senha foi processada.</div>"
            + "<div>Para recuperar sua senha, clique no link abaixo: </div>"
            + "<div><a href='" + link + "'>Recuperar senha</a></div>"
            + "<div>Caso não tenha solicitado a recuperação de senha, ignore este e-mail.</div>";
    }
}
