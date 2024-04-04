package RegionController;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import model.Conexion;
import model.RegionModel;
import javax.swing.JComboBox;

public class RegionController {
    public void showRegions(JTable tabla){
        try{
            Conexion cn = new Conexion();
            DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
            setInitializeTable(modelo);
            String[] columns = {"RegionId", "RegionDescription"};
            addColumsInTable(columns, modelo);
            
            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Region");
            while(resultSet.next()){
                RegionModel regionModel = new RegionModel();
                regionModel.setRegionId(resultSet.getInt("regionId"));
                regionModel.setRegionDescription(resultSet.getString("regionDescription"));
                modelo.addRow(regionModel.getProperties());
            }
            tabla.setModel(modelo);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void loadRegions(JComboBox combobox){
        try{
            Conexion cn = new Conexion();
            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT RegionDescription FROM Region");
            combobox.removeAllItems();
            while(resultSet.next()){
                combobox.addItem(resultSet.getString("regiondescription"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void setInitializeTable(DefaultTableModel modelo){
        modelo.setColumnCount(0);
        modelo.setRowCount(0);
    }
    public void addColumsInTable(String[] columns, DefaultTableModel modelo){
        for(String column: columns){
            modelo.addColumn(column);
        }
    }
}
