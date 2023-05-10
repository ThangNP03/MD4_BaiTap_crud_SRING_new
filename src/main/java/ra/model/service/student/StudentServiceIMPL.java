package ra.model.service.student;

import ra.model.entity.Students;
import ra.model.service.util.ConnectionToDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    @Override
    public List<Students> findAll() throws SQLException {
       List<Students> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConneection();
            CallableStatement callst = conn.prepareCall("{call PROC_GETALLSTUDENT()}");
            ResultSet rs = callst.executeQuery();
            while (rs.next()){
                Students st = new Students();
                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setSex(rs.getBoolean("gen"));
                st.setAddress(rs.getString("address"));
                list.add(st);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ConnectionToDB.close(conn);
        }

        return list;
    }

    @Override
    public Boolean save(Students students) throws SQLException {
        Connection conn = null;
        try {
            conn = ConnectionToDB.getConneection();
            CallableStatement callst = conn.prepareCall("{call PROC_CREATESTUDENT(?,?,?,?)}");
            callst.setString(1,students.getName());
            callst.setInt(2,students.getAge());
            callst.setBoolean(3,students.isSex());
            callst.setString(4,students.getAddress());
            callst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            ConnectionToDB.close(conn);
        }
        return true;
    }

    @Override
    public boolean update(Students students) {
        return false;
    }

    @Override
    public Students findById(Integer integer) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<Students> findByName(String name) {
        return null;
    }
}
