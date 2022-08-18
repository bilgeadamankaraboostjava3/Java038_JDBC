package com.muhammet.utility;

import com.muhammet.repository.MusteriRepository;
import com.muhammet.repository.entity.Musteri;

public class Runner_Repository {

	public static void main(String[] args) {
		MusteriRepository musteriRepository = new MusteriRepository();
		//musteriRepository.delete(12);
		//musteriRepository.findAll().forEach(System.out::println);
		//Musteri musteri = musteriRepository.findById(40);
		//if(musteri!=null)
		//	System.out.println(musteri.toString());
		musteriRepository.findByColumnValue("adres", "%r%").forEach(System.out::println);
		System.out.println("UYGULAMA BÝTTÝ.");

	}

}
