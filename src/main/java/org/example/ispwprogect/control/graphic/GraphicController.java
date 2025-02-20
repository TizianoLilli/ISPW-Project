package org.example.ispwprogect.control.graphic;

import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.exception.SystemException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;

public abstract class GraphicController {

    public abstract void init(int sessionId, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException;

}
