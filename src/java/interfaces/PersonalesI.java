package interfaces;

import java.util.List;
import modelo.PersonalesM;

public interface PersonalesI {

    void addPersonales (PersonalesM personales) throws Exception;

    List<PersonalesM> listarPersonales() throws Exception;

    void editarPersonales(PersonalesM personales) throws Exception;

    void deshabilitarPersonales(PersonalesM personales) throws Exception;

}
