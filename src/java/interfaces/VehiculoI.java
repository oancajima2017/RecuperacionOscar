package interfaces;

import java.util.List;
import modelo.VehiculoM;

public interface VehiculoI {

    void addVehiculo(VehiculoM vehiculo) throws Exception;

    List<VehiculoM> listarVehiculo() throws Exception;

    void editarVehiculo(VehiculoM vehiculo) throws Exception;

    void deshabilitarVehiculo(VehiculoM vehiculo) throws Exception;

}
