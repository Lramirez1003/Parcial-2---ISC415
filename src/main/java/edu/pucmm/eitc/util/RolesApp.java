package edu.pucmm.eitc.util;

import io.javalin.core.security.RouteRole;

public enum RolesApp implements RouteRole {
    ROLE_USUARIO,

    ROLE_ADMIN;
}
