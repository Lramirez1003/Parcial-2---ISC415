package edu.pucmm.eitc.services;

import edu.pucmm.eitc.services.DataBaseServices;
import edu.pucmm.eitc.encapsulaciones.Formulario;
import jakarta.persistence.*;

import java.util.List;

public class FormularioServices extends DataBaseServices<Formulario>{

    private static FormularioServices instancia;

    FormularioServices(){super(Formulario.class);}

    public static FormularioServices getInstancia() {
        if (instancia == null) {
            instancia = new FormularioServices();
        }
        return instancia;
    }

    public void BorrarForm(Object id){
        Formulario ent=find(id);
        ent = editar(ent);
    }

    public List<Formulario> EncontrarForm(int in, int out) throws PersistenceException{
        EntityManager em = getEntityManager();
        Query sql = em.createNativeQuery("select * from Formulario",Formulario.class);
        sql.setFirstResult(in);
        if(out !=0){
            sql.setMaxResults(out);
        }
        List<Formulario> lista = sql.getResultList();
        return lista;
    }

    public int pagina(){
        int size = 10;
        EntityManager em = getEntityManager();
        Query sql = em.createNativeQuery("select * from Formulario",Formulario.class);
        int rs = sql.getResultList().size();
        int ultima = (int)(Math.ceil(rs/size));
        return ultima;
    }

}
