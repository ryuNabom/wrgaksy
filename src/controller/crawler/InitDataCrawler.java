package controller.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class InitDataCrawler {
	static String name = " .card-content__title"; // url 에서 이름을 담고 있는 css class
	static String price = " .card-content__price-discount"; // url 에서 가격을 담고 있는 css class
	static String img = " .lazyload";
	static String sub = " .card-content__text";

	public static Document connect() {
		String url = "https://www.zipbanchan.co.kr/shop/goods/goods_list.php";
		try {
			Document doc = Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			System.out.println("url 접근중 이상 발생!");
		}
		return null;
	}

	public static ArrayList<String> getName(String page, Document doc) { // css 쿼리중 각 항목에 해당하는 쿼리를 뽑아 이름을 반환한다
		ArrayList<String> result = new ArrayList<String>();
		Elements names = doc.select(page + name);
		for (Element name : names) {
			result.add(name.text());
		}
		return result;
	}

	public static ArrayList<Integer> getPrice(String page, Document doc) {
		ArrayList<Integer> result = new ArrayList<>();
		Elements prices = doc.select(page + price);
		for (Element price : prices) {
			String target = price.text();
			target = target.substring(0, target.length() - 1); // 마지막 "원" 제거
			target = target.replaceAll("\\,", ""); // , 콤마 제거
			result.add(Integer.valueOf(target)); // 결과에 저장
		}
		return result;
	}

	public static ArrayList<String> getSub(String page, Document doc) {
		ArrayList<String> result = new ArrayList<String>();
		Elements subs = doc.select(page + sub);
		for (Element element : subs) {
			result.add(element.text());
		}
		return result;
	}

	public static ArrayList<String> getImg(String page, Document doc) {
		ArrayList<String> result = new ArrayList<String>();
		Elements images = doc.select(page + img);
		for (Element image : images) {
			result.add(image.attr("data-src")); // data-src 속성 값에 img url 이 저장되어있다
		}
		return result;
	}
}
