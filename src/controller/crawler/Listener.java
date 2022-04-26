//package controller.crawler;
//
//import model.product.ProductDAO;
//import model.product.ProductVO;
//import org.jsoup.nodes.Document;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.util.ArrayList;
//
//@WebListener
//public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
//
//	public Listener() {
//	}
//
//	@Override
//	public void contextInitialized(ServletContextEvent sce) {
//		/*
//		 * This method is called when the servlet context is initialized(when the Web
//		 * application is deployed).
//		 */
//		ProductDAO dao = new ProductDAO();
//		ProductVO vo = null; // 초기값 null 설정
//		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
//		Document doc = InitDataCrawler.connect(); // 크롤러로 부터 html 파싱
//		// 메인 요리
//		String main = "#catecd_001007";
//		// 국
//		String soup = "#catecd_001006";
//		// 무침
//		String seasonedSideDish = "#catecd_001003";
//		// 볶음
//		String friedSideDish = "#catecd_001009";
//		// 조림
//		String braisedSideDish = "#catecd_001002";
//
//		// 메인 요리
//		ArrayList<String> mainName = InitDataCrawler.getName(main, doc);
//		ArrayList<Integer> mainPrice = InitDataCrawler.getPrice(main, doc);
//		ArrayList<String> mainImg = InitDataCrawler.getImg(main, doc);
//		ArrayList<String> mainDetail = InitDataCrawler.getSub(main, doc);
//		ArrayList<ProductVO> mainData = new ArrayList<ProductVO>();
//		for (int i = 0; i < mainName.size(); i++) {
//			vo = new ProductVO();
//			vo.setProduct_name(mainName.get(i));
//			vo.setProduct_price(mainPrice.get(i));
//			vo.setProduct_image(mainImg.get(i));
//			vo.setProduct_details(mainDetail.get(i));
//			vo.setProduct_type("main");
//			mainData.add(vo);
//		}
//		dao.insertAll(mainData); // 메인 데이터들 insert 진행
//		System.out.println("mainData insert 완료");
//
//		// 국
//		ArrayList<String> soupName = InitDataCrawler.getName(soup, doc);
//		ArrayList<Integer> soupPrice = InitDataCrawler.getPrice(soup, doc);
//		ArrayList<String> soupImg = InitDataCrawler.getImg(soup, doc);
//		ArrayList<String> soupDetail = InitDataCrawler.getSub(soup, doc);
//		ArrayList<ProductVO> soupData = new ArrayList<ProductVO>();
//		for (int i = 0; i < soupName.size(); i++) {
//			vo = new ProductVO();
//			vo.setProduct_name(soupName.get(i));
//			vo.setProduct_price(soupPrice.get(i));
//			vo.setProduct_image(soupImg.get(i));
//			vo.setProduct_details(soupDetail.get(i));
//			vo.setProduct_type("soup");
//			soupData.add(vo);
//		}
//		dao.insertAll(soupData); // 국 데이터들 insert 진행
//		System.out.println("soupData insert 완료");
//
//		// 밑반찬
//		// 무침
//		ArrayList<String> seasonedSideDishName = InitDataCrawler.getName(seasonedSideDish, doc);
//		ArrayList<Integer> seasonedSideDishPrice = InitDataCrawler.getPrice(seasonedSideDish, doc);
//		ArrayList<String> seasonedSideDishImg = InitDataCrawler.getImg(seasonedSideDish, doc);
//		ArrayList<String> seasonedSideDishDetail = InitDataCrawler.getSub(seasonedSideDish, doc);
//		ArrayList<ProductVO> seasonedSideDishData = new ArrayList<ProductVO>();
//		for (int i = 0; i < seasonedSideDishName.size(); i++) {
//			vo = new ProductVO();
//			vo.setProduct_name(seasonedSideDishName.get(i));
//			vo.setProduct_price(seasonedSideDishPrice.get(i));
//			vo.setProduct_image(seasonedSideDishImg.get(i));
//			vo.setProduct_details(seasonedSideDishDetail.get(i));
//			vo.setProduct_type("sideDish");
//			seasonedSideDishData.add(vo);
//		}
//		dao.insertAll(seasonedSideDishData); // 무침 데이터들 insert 진행
//		System.out.println("seasonedSideDishData insert 완료");
//		// 볶음
//		ArrayList<String> friedSideDishName = InitDataCrawler.getName(friedSideDish, doc);
//		ArrayList<Integer> friedSideDishPrice = InitDataCrawler.getPrice(friedSideDish, doc);
//		ArrayList<String> friedSideDishImg = InitDataCrawler.getImg(friedSideDish, doc);
//		ArrayList<String> friedSideDishDetail = InitDataCrawler.getSub(friedSideDish, doc);
//		ArrayList<ProductVO> friedSideDishData = new ArrayList<ProductVO>();
//		for (int i = 0; i < friedSideDishName.size(); i++) {
//			vo = new ProductVO();
//			vo.setProduct_name(friedSideDishName.get(i));
//			vo.setProduct_price(friedSideDishPrice.get(i));
//			vo.setProduct_image(friedSideDishImg.get(i));
//			vo.setProduct_details(friedSideDishDetail.get(i));
//			vo.setProduct_type("sideDish");
//			friedSideDishData.add(vo);
//		}
//		dao.insertAll(friedSideDishData); // 볶음 데이터들 insert 진행
//		System.out.println("friedSideDishData insert 완료");
//		// 조림
//		ArrayList<String> braisedSideDishName = InitDataCrawler.getName(braisedSideDish, doc);
//		ArrayList<Integer> braisedSideDishPrice = InitDataCrawler.getPrice(braisedSideDish, doc);
//		ArrayList<String> braisedSideDishImg = InitDataCrawler.getImg(braisedSideDish, doc);
//		ArrayList<String> braisedSideDishDetail = InitDataCrawler.getSub(braisedSideDish, doc);
//		ArrayList<ProductVO> braisedSideDishData = new ArrayList<ProductVO>();
//		for (int i = 0; i < braisedSideDishName.size(); i++) {
//			vo = new ProductVO();
//			vo.setProduct_name(braisedSideDishName.get(i));
//			vo.setProduct_price(braisedSideDishPrice.get(i));
//			vo.setProduct_image(braisedSideDishImg.get(i));
//			vo.setProduct_details(braisedSideDishDetail.get(i));
//			vo.setProduct_type("sideDish");
//			braisedSideDishData.add(vo);
//		}
//		dao.insertAll(braisedSideDishData); // 조림 데이터들 insert 진행
//		System.out.println("braisedSideDishData insert 완료");
//	}
//
//	@Override
//	public void contextDestroyed(ServletContextEvent sce) {
//		/*
//		 * This method is called when the servlet Context is undeployed or Application
//		 * Server shuts down.
//		 */
//		// 서버 종료시 모든 데이터 삭제
//		ProductDAO dao = new ProductDAO();
//		dao.deleteAll();
//	}
//}
