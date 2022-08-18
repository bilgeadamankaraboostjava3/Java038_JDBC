package com.muhammet.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.muhammet.repository.entity.Musteri;
import static com.muhammet.utility.Constants.*;
public class MusteriRepository implements ICrud<Musteri>{

	private CRUD crud;
	private ResultSet rs; // select sorgularýndan dönen tablolarý burada tutuyor olacaðýz. 
	public MusteriRepository() {
		crud = new CRUD(DATABASE); // NOT: import static satýrýndan eklenen kod ile bu DATABASE String i okuyabiliyorum.
	}
	
	@Override
	public void save(Musteri t) {		
		String SQL = "insert into tblmusteri(ad,soyad,adres,telefon) values"+
				"('"+t.getAd()+"','"+t.getSoyad()+"','"+t.getAdres()+"','"+t.getTelefon()+"')";
		try {
			crud.ExecuteQuery(SQL);
		} catch (SQLException e) {
			System.out.println("Müþteri Kayýt Ýþlemi Hata...: "+ e.toString());
		}		
	}

	@Override
	public void update(Musteri t) {
		String SQL = "update tblmusteri "
				+ "set ad='"+t.getAd()+"', "
				+ "soyad='"+t.getSoyad()+"',"
				+ "adres='"+t.getAdres()+"', "
				+ "telefon='"+t.getTelefon()+"',"
				+ "durum="+t.getDurum()
				+ " where id="+t.getId();
		try {			
			crud.ExecuteQuery(SQL);
		} catch (SQLException e) {
			System.out.println("Müþteri Güncelleme Ýþlemi Hata...: "+ e.toString());
		}
		
	}

	@Override
	public void delete(int id) {
		String SQL = "delete from tblmusteri where id="+id;
		try {
			crud.ExecuteQuery(SQL);
		} catch (SQLException e) {
			System.out.println("Müþteri Kayýt Ýþlemi Hata...: "+ e.toString());
		}	
		
	}

	@Override
	public List<Musteri> findAll() {
		List<Musteri> mlist = new ArrayList();
		try {
			rs = crud.findAll("select * from tblmusteri");
			while(rs.next()) {
				int id = rs.getInt("id"); // rs.getInt(1);
				String ad= rs.getString("ad");//  rs.getInt(2);
				String soyad = rs.getString("soyad");
				String adres = rs.getString("adres");
				String telefon = rs.getString("telefon");
				int durum = rs.getInt("durum");
				mlist.add(new Musteri(id, ad, soyad, telefon, adres, durum));
			}
		}catch (Exception e) {
			System.out.println("Müþteri TAblosu Okuma hatasý...: "+ e.toString());
		}
		
		
		return mlist;
	}

	@Override
	public Musteri findById(int id) {
		Musteri musteri = null;
		try {
			rs = crud.findAll("select * from tblmusteri where id="+id);
			while(rs.next()) {				
				String ad= rs.getString("ad");//  rs.getInt(2);
				String soyad = rs.getString("soyad");
				String adres = rs.getString("adres");
				String telefon = rs.getString("telefon");
				int durum = rs.getInt("durum");
				musteri = new Musteri(id, ad, soyad, telefon, adres, durum);
			}
		}catch (Exception e) {
			System.out.println("Müþteri TAblosu Okuma hatasý...: "+ e.toString());
		}
		
		return musteri;
	}

	@Override
	public List<Musteri> findByColumnValue(String columnName, Object value) {
		List<Musteri> mlist = new ArrayList();
		try {
			/**
			 * Eðer value -> String '' deðil ise 
			 */
			try {
				String Svalue = (String)value;
				rs = crud.findAll("select * from tblmusteri where "+columnName+" ilike ('"+Svalue+"')");
			}catch (Exception e) {
				rs = crud.findAll("select * from tblmusteri where "+columnName+"="+value);
			}			
			while(rs.next()) {
				int id = rs.getInt("id"); // rs.getInt(1);
				String ad= rs.getString("ad");//  rs.getInt(2);
				String soyad = rs.getString("soyad");
				String adres = rs.getString("adres");
				String telefon = rs.getString("telefon");
				int durum = rs.getInt("durum");
				mlist.add(new Musteri(id, ad, soyad, telefon, adres, durum));
			}
		}catch (Exception e) {
			System.out.println("Müþteri TAblosu Okuma hatasý...: "+ e.toString());
		}
		
		
		return mlist;
	}

	
}
