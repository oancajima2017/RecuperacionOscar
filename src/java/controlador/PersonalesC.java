package controlador;

import dao.PersonalesD;
import modelo.PersonalesM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import lombok.Data;

@Named(value = "personalesC")
@SessionScoped
@Data
public class PersonalesC implements Serializable {

    PersonalesM personales = new PersonalesM();

    private List<PersonalesM> listaPersonales;

    private String per, psw;

    @PostConstruct
    public void inicio() {
        try {
            listarPersonales();
            limpiarPersonales();
        } catch (Exception ex) {
            Logger.getLogger(PersonalesC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void limpiarPersonales() {
        personales = new PersonalesM();
    }

    public void addPersonales() throws Exception {
        PersonalesD dao;
        try {
            dao = new PersonalesD();
            dao.addPersonales(personales);
            listarPersonales();
            limpiarPersonales();
        } catch (Exception e) {
            throw e;
        }

    }

    public void listarPersonales() throws Exception {
        PersonalesD dao;
        try {
            dao = new PersonalesD();
            listaPersonales = dao.listarPersonales();
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarPersonales() throws Exception {
        PersonalesD dao;
        try {
            dao = new PersonalesD();
            dao.editarPersonales(personales);
            listarPersonales();
        } catch (Exception e) {
            throw e;
        }
    }

    public void deshabilitarPersonales() throws Exception {
        PersonalesD dao;
        try {
            dao = new PersonalesD();
            dao.deshabilitarPersonales(personales);
            listarPersonales();
        } catch (Exception e) {
            throw e;
        }
    }

}
