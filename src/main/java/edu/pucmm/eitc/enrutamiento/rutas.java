package edu.pucmm.eitc.enrutamiento;

import edu.pucmm.eitc.services.*;
import edu.pucmm.eitc.util.BaseControlador;
import io.javalin.Javalin;

import edu.pucmm.eitc.encapsulaciones.* ;
import org.jasypt.util.text.AES256TextEncryptor;

import java.util.*;
        public class rutas extends BaseControlador {

            public rutas(Javalin app) {super(app);}

            public void aplicarRutas() {

                app.before(ctx -> {
                    Formulario formu = ctx.sessionAttribute("formu");
                    if(formu == null){
                        formu = new Formulario();
                    }
                    ctx.sessionAttribute("formu",formu);

                });




                app.get("/",ctx -> {
                ctx.render("/publico/home.vm");


                });

                app.get("/Formulario",ctx -> {

                    if(ctx.cookie("usuario" ) == null || ctx.cookie("password") == null){
                        ctx.redirect("/auth/Formulario");
                        return;
                    }


                    Map<String,Object>modelo = new HashMap<>();
                    modelo.put("accion","/Formulario");
                    Formulario formu = ctx.sessionAttribute("formu");
                    ctx.render("/publico/formulario.vm",modelo);
                });

                app.post("/Formulario",ctx -> {
                    String nombre= ctx.formParam("nombre");
                    String sector= ctx.formParam("sector");
                    String nivel_esc= ctx.formParam("nivel_esc");
                    String usu = ctx.cookie("usuario");

                    Formulario tmp = new Formulario(nombre,sector,nivel_esc,usu);

                    FormularioServices.getInstancia().crear(tmp);
                    ctx.redirect("/");
                });



                app.get("/auth/{param}", ctx -> {
                    String param = ctx.pathParam("param");
                    Map<String, Object> modelo = new HashMap<>();
                    modelo.put("param",param);
                    ctx.render("/publico/login.vm",modelo);
                });

                app.post("/auth/{param}",ctx -> {
                    String user = ctx.formParam("usuario");
                    String pass = ctx.formParam("password");
                    String tmp = ctx.formParam("param");
                    String rec = ctx.formParam("remember");

                    if (user == null || pass == null){
                        ctx.redirect("/auth/"+tmp);
                    }
                    Usuario temp= new Usuario(user,pass);
                    AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
                    textEncryptor.setPassword("jesus");
                    pass = textEncryptor.encrypt(pass);
                    if (rec !=null) {
                        ctx.cookie("usuario", user,(3600*24*7));
                        ctx.cookie("password", pass,(3600*24*7));
                    }
                    ctx.cookie("usuario", user);
                    ctx.cookie("password", pass);


                    ctx.redirect("/Formulario");

                });

                app.get("/logout",ctx -> {
                    if (ctx.cookie("usuario")!=null && ctx.cookie("password")!=null){
                        ctx.removeCookie("usuario");
                        ctx.removeCookie("password");
                    }
                    ctx.redirect("/");
                });


            }
        }
