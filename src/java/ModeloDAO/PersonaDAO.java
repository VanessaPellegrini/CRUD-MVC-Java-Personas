
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();
    
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="select * from persona";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();
                per.setId(rs.getInt("Id"));
                per.setNom(rs.getString("Nombres"));
                per.setApellido(rs.getString("apellido"));
                per.setEdad(rs.getInt("edad"));
                per.setSexo(rs.getString("sexo").charAt(0));
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Persona list(int id) {
        String sql="select * from persona where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nombres"));
                p.setApellido(rs.getString("apellido"));
                p.setEdad(rs.getInt("edad"));
                p.setSexo(rs.getString("sexo").charAt(0));
                
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {
       String sql="insert into persona(Nombres, apellido, edad, sexo)"
               + "values('"+per.getNom()+"','"+per.getApellido()+"','"+per.getEdad()+"','"+per.getSexo()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Persona per) {
        String sql="update persona set Nombres='"+per.getNom()+"',apellido='"+per.getApellido()+"',edad='"+per.getEdad()+"',sexo='"+per.getSexo()+"'where Id="+per.getId();
        System.out.println(sql);
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from persona where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
