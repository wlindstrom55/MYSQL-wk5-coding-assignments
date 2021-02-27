package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Sodas;


public class SodasDao {
	
	private Connection connection;
	
	public SodasDao() { // constructor
		connection = DBConnectionSodas.getInstance().getConnection(); //instance of connection
	}
	
	public List<Sodas> getAllSodas() throws SQLException {
		List<Sodas> out = new ArrayList<>(); //"out" here is the output, the list of all sodas
		
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery( "select * from sodas" );
		
		while (rs.next()) {
			out.add( new Sodas(rs.getInt(1), rs.getString(2)));
		}
		
		return out;
	}
	// The method below for getting sodas by id is not used currently. Commented out for now.
	
//	public void getSodaById(int id) throws SQLException {  
//		PreparedStatement ps = connection.prepareStatement("SELECT * FROM teams WHERE id = ?");
//		ps.setInt(1,  id);
//		ps.executeQuery();
//	}
	
	public void createNewSoda(String sodaName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("INSERT INTO sodas(name) VALUES(?)");
		ps.setString(1, sodaName);
		ps.executeUpdate();
	}
	
	public void deleteSodaById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM sodas WHERE id = ?");
		ps.setInt(1,  id);
		ps.executeUpdate();
	}
	
	public void updateSodas( int id, String name ) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("UPDATE sodas SET name = ? WHERE id = ?" );
		ps.setString( 1,  name);
		ps.setInt(2,  id);
		ps.executeUpdate();
}
	
}
