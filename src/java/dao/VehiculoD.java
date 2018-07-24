package dao;

import interfaces.VehiculoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.VehiculoM;

public class VehiculoD extends Dao implements VehiculoI {

    @Override
    public void addVehiculo(VehiculoM vehiculo) throws Exception {
        this.Conexion();
        try {
            String sql = "insert into Vehiculo (Modelo_Ve, Marca_Ve, Est_Ve, Cod_Ve) values(?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, vehiculo.getModelo_Ve());
            ps.setString(2, vehiculo.getMarca_Ve());
            ps.setString(3, "A");
            ps.setString(4, vehiculo.getCod_Ve());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<VehiculoM> listarVehiculo() throws Exception {
        List<VehiculoM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "Select * from Vehiculo WHERE Est_Ve='A' order by Cod_Ve desc";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            VehiculoM vehiculo;
            while (rs.next()) {
                vehiculo = new VehiculoM();
                vehiculo.setCod_Ve(rs.getString("Cod_Ve"));
                vehiculo.setModelo_Ve(rs.getString("Modelo_Ve"));
                vehiculo.setMarca_Ve(rs.getString("Marca_Ve"));
                vehiculo.setEst_Ve(rs.getString("Est_Ve"));
                lista.add(vehiculo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public void editarVehiculo(VehiculoM vehiculo) throws Exception {
        this.Conexion();
        try {
            String sql = "update Vehiculo set Modelo_Ve=?, Marca_Ve=? where Cod_Ve=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, vehiculo.getModelo_Ve());
            ps.setString(2, vehiculo.getMarca_Ve());
            ps.setString(3, vehiculo.getCod_Ve());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void deshabilitarVehiculo(VehiculoM vehiculo) throws Exception {
        this.Conexion();
        try {
            String sql = "update Vehiculo set Est_Ve=? where Cod_Ve=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setString(2, vehiculo.getCod_Ve());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }
}
