package controlador;

import dao.VehiculoD;
import modelo.VehiculoM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import lombok.Data;

@Named(value = "vehiculoC")
@SessionScoped
@Data
public class VehiculoC implements Serializable {

    VehiculoM vehiculo = new VehiculoM();

    private List<VehiculoM> listaVehiculo;

    private String ve, psw;

    @PostConstruct
    public void inicio() {
        try {
            listarVehiculo();
            limpiarVehiculo();
        } catch (Exception ex) {
            Logger.getLogger(VehiculoC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void limpiarVehiculo() {
        vehiculo = new VehiculoM();
    }

    public void addVehiculo() throws Exception {
        VehiculoD dao;
        try {
            dao = new VehiculoD();
            dao.addVehiculo(vehiculo);
            listarVehiculo();
            limpiarVehiculo();
        } catch (Exception e) {
            throw e;
        }

    }

    public void listarVehiculo() throws Exception {
        VehiculoD dao;
        try {
            dao = new VehiculoD();
            listaVehiculo = dao.listarVehiculo();
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarVehiculo() throws Exception {
        VehiculoD dao;
        try {
            dao = new VehiculoD();
            dao.editarVehiculo(vehiculo);
            listarVehiculo();
        } catch (Exception e) {
            throw e;
        }
    }

    public void deshabilitarVehiculo() throws Exception {
        VehiculoD dao;
        try {
            dao = new VehiculoD();
            dao.deshabilitarVehiculo(vehiculo);
            listarVehiculo();
        } catch (Exception e) {
            throw e;
        }
    }

}
