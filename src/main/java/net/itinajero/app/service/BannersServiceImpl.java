package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

//import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

//@Service
public class BannersServiceImpl implements IBannersService{
	List<Banner> listBanners = null;
	public BannersServiceImpl() {
		System.out.println("Creacion de servicio BannersServiceImpl");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			listBanners = new LinkedList<>();
			
			Banner banner1 = new Banner();
			banner1.setTitle("Slide1");
			banner1.setFile("slide1.jpg");
			banner1.setStatus("Activo");
			banner1.setDate(formatter.parse("02-02-2018"));
			
			Banner banner2 = new Banner();
			banner2.setTitle("Slide2");
			banner2.setFile("slide2.jpg");
			banner2.setStatus("Inactivo");
			banner2.setDate(formatter.parse("04-03-2018"));
			
			Banner banner3 = new Banner();
			banner3.setTitle("Slide3");
			banner3.setFile("slide3.jpg");
			banner3.setStatus("Inactivo");
			banner3.setDate(formatter.parse("07-04-2018"));
			
			Banner banner4 = new Banner();
			banner4.setTitle("Slide4");
			banner4.setFile("slide4.jpg");
			banner4.setStatus("Activo");
			banner4.setDate(formatter.parse("19-09-2018"));
			
			listBanners.add(banner1);
			listBanners.add(banner2);
			listBanners.add(banner3);
			listBanners.add(banner4);
			
		}catch(ParseException e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(Banner banner) {
		listBanners.add(banner);
	}

	@Override
	public List<Banner> searchAll() {
		// TODO Auto-generated method stub
		return listBanners;
	}

	@Override
	public Banner searchById(int idBanner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idBanner) {
		// TODO Auto-generated method stub
		
	}
}
