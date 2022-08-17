package com.muhammet.repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class CRUD {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private final String USERNAME = "postgres";
	private final String PASSWORD = "root";
	private final String URL = "jdbc:postgresql://localhost:5432/";	
	private final String DatabaseName;
	
	public CRUD(String DatabaseName) {
		this.DatabaseName = DatabaseName;
	}
	
	private boolean OpenConnection() {
		try {
			Driver.class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL+this.DatabaseName,USERNAME,PASSWORD);
			return true;
		}catch (Exception e) {
			System.out.println("Ba�lant� a�ma sorunu...: "+ e.toString());
			return false;
		}		
	}
	
	private void CloseConnection() {
		try {
			if(!conn.isClosed())
				conn.close();
		}catch (Exception e) {
			System.out.println("Ba�lant� kapatma sorunu...: "+e.toString());
		}
	}
	
	public void ExecuteQuery(String sql) throws SQLException {
		if(OpenConnection()) {
			ps = conn.prepareCall(sql);
			ps.executeUpdate();
			CloseConnection();
		}else {
			System.out.println("Ba�lant� A��lamad�");
		}
	}
	
	public void findAll(String sql) throws SQLException {
		if(OpenConnection()) {
			ps = conn.prepareCall(sql);
			rs = ps.executeQuery();// select sorgusu �al��t�r�l�r ve geriye bir tablo sonu�. olarak d�ner
			//rs.getArray(1);
			//rs.getArray("ad");
			while(rs.next()) {
				System.out.println("Kullanc�...: ");
				//System.out.print(rs.getInt(1)+" - ");
				//System.out.print(rs.getString(2));
				System.out.print(rs.getInt("id"));
				System.out.print(rs.getString("ad"));
				
				System.out.println();
			}
			
			CloseConnection();
		}else {
			System.out.println("Ba�lant� A��lamad�");
		}
	}
	
}
