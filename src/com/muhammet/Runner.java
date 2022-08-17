package com.muhammet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Runner {

	public static void main(String[] args) throws Exception {
		// 1. Driver -> Java ile Herhangi bir DB in anla�abilmesi i�in gerekli paket
		// -- hangi DB kullanacak iseniz onun size sa�lamas� gereklidir. ararken;
		// postgresql jdbc driver download
		// mssql jdbc driver download
		// 2. S�r�c�y� kullanmak �zere ekleyin.
		Driver.class.forName("org.postgresql.Driver");
		// 3. Ba�lant�y� A�mak gerekli. Burada Ba�lant�y� a�mak i�in s�r�c�y� 
		// y�netmemiz gerekli.
		// E�er kendi bilgisayar�n�z� ba�lkanacak iseniz. local pc adresiniz
		// localhost - 127.0.0.1
		// D�KKAT!!! SqlConnectin String
		// Syntax: jdbc:postgresql://host:port/database
		String adres = "jdbc:postgresql://localhost:5432/TblSatis";		
		String kullaniciAdi = "postgres";
		String sifre = "root";
		System.out.println("Balant� A��l�yor");
		Connection conn = DriverManager
				.getConnection(adres,kullaniciAdi,sifre);
		// 4. SQL c�mlesini haz�rl�yoruz.
		String SQL = "insert into tblmusteri(ad,soyad,adres,telefon)values"
				+ " ('Java2','USER','Ankara','0 000 000 0000')";
		PreparedStatement pr = conn.prepareCall(SQL);
		// 5. Haz�rlana SQL c�mleci�i �al��t�r�l�r.
		pr.executeUpdate();
		System.out.println("Ekeleme Yap�ld�");
		// 6. A��lan ba�lant�lar kapat�l�r.
		conn.close();
		System.out.println("��lem Bitti");
	}

}
