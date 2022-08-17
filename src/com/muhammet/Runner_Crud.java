package com.muhammet;

import java.sql.SQLException;

import com.muhammet.repository.CRUD;

public class Runner_Crud {

	public static void main(String[] args) throws SQLException {
		
		CRUD crud = new CRUD("TblSatis");
		//crud.ExecuteQuery("insert into tblmusteri(ad) values('Adým Yok3')");
		//crud.ExecuteQuery("update tblmusteri set ad='Yeni Adýmyok 3' where id=13");
		//crud.ExecuteQuery("delete from tblmusteri where id=13");
		crud.findAll("select * from tblmusteri");
		System.out.println("Uygulama BÝTTÝ.");
	}

}
