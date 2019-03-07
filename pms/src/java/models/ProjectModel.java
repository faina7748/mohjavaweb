package models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProjectModel extends model{
    private int id;
    private String title;
    private String desc;
    
    public boolean insert(){
        String sql = "INSERT INTO project(title,description) " +
                     "VALUES('" + this.title + "','" + this.desc +"')";
        
        try{
            Statement stmt = this.getStmt();
            stmt.execute(sql); // insert, update, delete guna execute()           
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean delete(int id){
        String sql = "DELETE FROM project WHERE id = " + id;
        
        try{
            Statement stmt = this.getStmt();
            stmt.execute(sql); // insert, update, delete guna execute()           
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    // return one record
    public ProjectModel getOne(int id){ // return projectmodel
        
        String sql = "SELECT * FROM project WHERE id = " + id;        
        ProjectModel proj = new ProjectModel();
        
        try{
            Statement stmt = this.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){                
                proj.id = rs.getInt("id");
                proj.title = rs.getString("title");
                proj.desc = rs.getString("description");
            }            
        }catch (Exception e) {
               e.printStackTrace();
        }
        return proj;
    }
    
    public ArrayList getAll(){
        ArrayList arr = new ArrayList();
        String sql = "SELECT * FROM project";        
        
        try{
            Statement stmt = this.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                ProjectModel proj = new ProjectModel();
                proj.id = rs.getInt("id");
                proj.title = rs.getString("title");
                proj.desc = rs.getString("description");                
                arr.add(proj);
            }            
        }catch (Exception e) {
               e.printStackTrace();
        }
        return arr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public static void main(String[] args) {
        ProjectModel p = new ProjectModel();
        
        p.setTitle("System Testing");
        p.setDesc("testing..testing");
        p.insert();
        
        ArrayList list = p.getAll();
        for(int i=0; i<list.size();i++){
            ProjectModel pro = (ProjectModel) list.get(i);
            System.out.println(pro.title);
        }
    }
}
