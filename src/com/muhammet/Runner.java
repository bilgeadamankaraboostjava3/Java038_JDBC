package com.muhammet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Runner {

	public static void main(String[] args) throws Exception {
		// 1. Driver -> Java ile Herhangi bir DB in anlaþabilmesi için gerekli paket
		// -- hangi DB kullanacak iseniz onun size saðlamasý gereklidir. ararken;
		// postgresql jdbc driver download
		// mssql jdbc driver download
		// 2. Sürücüyü kullanmak üzere ekleyin.
		Driver.class.forName("org.postgresql.Driver");
		// 3. Baðlantýyý Açmak gerekli. Burada Baðlantýyý açmak için sürücüyü 
		// yönetmemiz gerekli.
		// Eðer kendi bilgisayarýnýzý baðlkanacak iseniz. local pc adresiniz
		// localhost - 127.0.0.1
		// DÝKKAT!!! SqlConnectin String
		// Syntax: jdbc:postgresql://host:port/database
		String adres = "jdbc:postgresql://localhost:5432/TblSatis";		
		String kullaniciAdi = "postgres";
		String sifre = "root";
		System.out.println("Balantý Açýlýyor");
		Connection conn = DriverManager
				.getConnection(adres,kullaniciAdi,sifre);
		// 4. SQL cümlesini hazýrlýyoruz.
		String SQL = "insert into tblmusteri(ad,soyad,adres,telefon)values"
				+ " ('Java2','USER','Ankara','0 000 000 0000')";
		PreparedStatement pr = conn.prepareCall(SQL);
		// 5. Hazýrlana SQL cümleciði çalýþtýrýlýr.
		pr.executeUpdate();
		System.out.println("Ekeleme Yapýldý");
		// 6. Açýlan baðlantýlar kapatýlýr.
		conn.close();
		System.out.println("Ýþlem Bitti");
	}

}
