package controller.crawler;

import model.product.ProductDAO;
import model.product.ProductVO;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class InitDataContructor {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductVO vo = null; // 초기값 null 설정
		Document doc = InitDataCrawler.connect(); // 크롤러로 부터 html 파싱
		// 메인 요리
		String main = "#catecd_001007";
		// 국
		String soup = "#catecd_001006";
		// 무침
		String seasonedSideDish = "#catecd_001003";
		// 볶음
		String friedSideDish = "#catecd_001009";
		// 조림
		String braisedSideDish = "#catecd_001002";

		// 메인 요리
		ArrayList<String> mainName = InitDataCrawler.getName(main, doc);
		ArrayList<Integer> mainPrice = InitDataCrawler.getPrice(main, doc);
		ArrayList<String> mainImg = InitDataCrawler.getImg(main, doc);
		ArrayList<String> mainDetail = InitDataCrawler.getSub(main, doc);
		ArrayList<ProductVO> mainData = new ArrayList<ProductVO>();
		for (int i = 0; i < mainName.size(); i++) {
			vo = new ProductVO();
			vo.setProduct_name(mainName.get(i));
			vo.setProduct_price(mainPrice.get(i));
			vo.setProduct_image(mainImg.get(i));
			vo.setDetails(mainDetail.get(i));
			vo.setProduct_type("메인");
			mainData.add(vo);
		}
		for (ProductVO mainDatum : mainData) {
			System.out.println(mainDatum);
		}
		dao.insertAll(mainData); // 메인 데이터들 insert 진행
		System.out.println("mainData insert 완료");

		// 국
		ArrayList<String> soupName = InitDataCrawler.getName(soup, doc);
		ArrayList<Integer> soupPrice = InitDataCrawler.getPrice(soup, doc);
		ArrayList<String> soupImg = InitDataCrawler.getImg(soup, doc);
		ArrayList<String> soupDetail = InitDataCrawler.getSub(soup, doc);
		ArrayList<ProductVO> soupData = new ArrayList<ProductVO>();
		for (int i = 0; i < soupName.size(); i++) {
			vo = new ProductVO();
			vo.setProduct_name(soupName.get(i));
			vo.setProduct_price(soupPrice.get(i));
			vo.setProduct_image(soupImg.get(i));
			vo.setDetails(soupDetail.get(i));
			vo.setProduct_type("국");
			soupData.add(vo);
		}
		dao.insertAll(soupData); // 국 데이터들 insert 진행
		System.out.println("soupData insert 완료");

		// 밑반찬
		// 무침
		ArrayList<String> seasonedSideDishName = InitDataCrawler.getName(seasonedSideDish, doc);
		ArrayList<Integer> seasonedSideDishPrice = InitDataCrawler.getPrice(seasonedSideDish, doc);
		ArrayList<String> seasonedSideDishImg = InitDataCrawler.getImg(seasonedSideDish, doc);
		ArrayList<String> seasonedSideDishDetail = InitDataCrawler.getSub(seasonedSideDish, doc);
		ArrayList<ProductVO> seasonedSideDishData = new ArrayList<ProductVO>();
		for (int i = 0; i < seasonedSideDishName.size(); i++) {
			vo = new ProductVO();
			vo.setProduct_name(seasonedSideDishName.get(i));
			vo.setProduct_price(seasonedSideDishPrice.get(i));
			vo.setProduct_image(seasonedSideDishImg.get(i));
			vo.setDetails(seasonedSideDishDetail.get(i));
			vo.setProduct_type("반찬");
			seasonedSideDishData.add(vo);
		}
		dao.insertAll(seasonedSideDishData); // 무침 데이터들 insert 진행
		System.out.println("seasonedSideDishData insert 완료");
		// 볶음
		ArrayList<String> friedSideDishName = InitDataCrawler.getName(friedSideDish, doc);
		ArrayList<Integer> friedSideDishPrice = InitDataCrawler.getPrice(friedSideDish, doc);
		ArrayList<String> friedSideDishImg = InitDataCrawler.getImg(friedSideDish, doc);
		ArrayList<String> friedSideDishDetail = InitDataCrawler.getSub(friedSideDish, doc);
		ArrayList<ProductVO> friedSideDishData = new ArrayList<ProductVO>();
		for (int i = 0; i < friedSideDishName.size(); i++) {
			vo = new ProductVO();
			vo.setProduct_name(friedSideDishName.get(i));
			vo.setProduct_price(friedSideDishPrice.get(i));
			vo.setProduct_image(friedSideDishImg.get(i));
			vo.setDetails(friedSideDishDetail.get(i));
			vo.setProduct_type("반찬");
			friedSideDishData.add(vo);
		}
		dao.insertAll(friedSideDishData); // 볶음 데이터들 insert 진행
		System.out.println("friedSideDishData insert 완료");
		// 조림
		ArrayList<String> braisedSideDishName = InitDataCrawler.getName(braisedSideDish, doc);
		ArrayList<Integer> braisedSideDishPrice = InitDataCrawler.getPrice(braisedSideDish, doc);
		ArrayList<String> braisedSideDishImg = InitDataCrawler.getImg(braisedSideDish, doc);
		ArrayList<String> braisedSideDishDetail = InitDataCrawler.getSub(braisedSideDish, doc);
		ArrayList<ProductVO> braisedSideDishData = new ArrayList<ProductVO>();
		for (int i = 0; i < braisedSideDishName.size(); i++) {
			vo = new ProductVO();
			vo.setProduct_name(braisedSideDishName.get(i));
			vo.setProduct_price(braisedSideDishPrice.get(i));
			vo.setProduct_image(braisedSideDishImg.get(i));
			vo.setDetails(braisedSideDishDetail.get(i));
			vo.setProduct_type("반찬");
			braisedSideDishData.add(vo);
		}
		dao.insertAll(braisedSideDishData); // 조림 데이터들 insert 진행
		System.out.println("braisedSideDishData insert 완료");
	}
}
