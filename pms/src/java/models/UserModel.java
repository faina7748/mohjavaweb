package models;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserModel extends model{
    private int id;
    private String staffid;
    private String pwd;
    private String role;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    // return true if exist, return false if not
    public boolean isExist(String staffId, String pwd){
        String sql = "SELECT * FROM users "
                     + "WHERE staff_id = '" + staffId + "' "
                     + "AND pwd = '" + pwd + "'";
        System.out.println(sql);       
        try{
            Statement stmt = this.getStmt();
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                this.id = rs.getInt("id");
                this.staffid = rs.getString("staff_id");
                this.pwd = rs.getString("pwd");
                this.name = rs.getString("name");
                this.role = rs.getString("role");                
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }        
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public static void main(String[] args) {
        UserModel user = new UserModel();
        if(user.isExist("123456", "122456")){
            System.out.println("ok");
        }else{
            System.out.println("ko");
        }
    }
}
