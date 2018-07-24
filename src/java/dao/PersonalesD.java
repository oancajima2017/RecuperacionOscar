package dao;

import interfaces.PersonalesI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.PersonalesM;

public class PersonalesD extends Dao implements PersonalesI {

    @Override
    public void addPersonales(PersonalesM personales) throws Exception {
        this.Conexion();
        try {
            String sql = "insert into Personales (Nom_Per, Ape_Per, Dni_Per, Est_Per, Cod_Per) values(?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, personales.getNom_Per());
            ps.setString(2, personales.getApe_Per());
            ps.setString(3, personales.getDni_Per());
            ps.setString(4, "A");
            ps.setString(5, personales.getCod_Per());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<PersonalesM> listarPersonales() throws Exception {
        List<PersonalesM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "Select * from Personales WHERE Est_Per='A' order by Cod_Per desc";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            PersonalesM personales;
            while (rs.next()) {
                personales = new PersonalesM();
                personales.setCod_Per(rs.getString("Cod_Per"));
                personales.setNom_Per(rs.getString("Nom_Per"));
                personales.setApe_Per(rs.getString("Ape_Per"));
                personales.setDni_Per(rs.getString("Dni_Per"));
                personales.setEst_Per(rs.getString("Est_Per"));
                lista.add(personales);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public void editarPersonales(PersonalesM personales) throws Exception {
        this.Conexion();
        try {
            String sql = "update Personales set Nom_Per=?, Ape_Per=?, Dni_Per=? where Cod_Per=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, personales.getNom_Per());
            ps.setString(2, personales.getApe_Per());
            ps.setString(3, personales.getDni_Per());
            ps.setString(4, personales.getCod_Per());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void deshabilitarPersonales(PersonalesM personales) throws Exception {
        this.Conexion();
        try {
            String sql = "update Personales set Est_Per=? where Cod_Per=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, personales.getCod_Per());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }
}
