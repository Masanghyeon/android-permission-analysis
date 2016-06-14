package kr.co.kau;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import kr.co.kau.analsys.MorphemeAnalysor;
import kr.co.kau.model.ApplicationVO;
import kr.co.kau.service.ApplicationDAO;

public class GooglePlayParser {
	public static String FINANCE = "FINANCE/collection/topselling_free";
	public static String ADUCATION = "EDUCATION/collection/topselling_free";
	public static String WEATHER = "WEATHER/collection/topselling_free";
	public static String BOOKS_AND_REFERENCE = "BOOKS_AND_REFERENCE/collection/topselling_free";
	public static String SPORTS = "SPORTS/collection/topselling_free";
	public static String SHOPING = "SHOPPING/collection/topselling_free";
	public static String TRABEL_AND_LOCAL = "TRAVEL_AND_LOCAL/collection/topselling_free";
	public static String MEDICAL = "MEDICAL/collection/topselling_free";
	public static String GAME = "GAME/collection/topselling_free";
	public static String FAMILY = "FAMILY/collection/topselling_free";
	
	public static String CATEGORYS [] = {FINANCE, /*WEATHER, BOOKS_AND_REFERENCE, SPORTS,
			SHOPING, TRABEL_AND_LOCAL, MEDICAL, GAME, FAMILY*/};

	public void googlePlayParsing() {
		ApplicationDAO dao = new ApplicationDAO();
		
		Document doc;
		try {
			for(String category:CATEGORYS ){
				doc = Jsoup.connect("https://play.google.com/store/apps/category/"+category)
						.timeout(2000000000)
						.get();
				System.out.println("Be parsing......");
				
				Elements titles = doc.select("a.title");
				String aUrl;
				for(Element title:titles){
					ApplicationVO app = new ApplicationVO();
					aUrl = title.attr("href").trim();

					doc = Jsoup.connect("https://play.google.com"+aUrl)
							.timeout(200000000)
							.get();

					Elements aTitle= doc.select("div.id-app-title");
					Elements aCategory = doc.select("a.document-subtitle.category");
					Elements aContent = doc.select("div.show-more-content.text-body");

//					Elements aPermissions = doc.select("div.bucket-icon-and-title");

					app.setaTitle(aTitle.text().trim());
					app.setaCategory(aCategory.text().trim());
//					app.setAPermissions(aPermissions.text());
					app.setaUrl(aUrl);
					
					System.out.println(app.toString());
					
					Map<String,Integer> analysis = new MorphemeAnalysor(aContent.text()).morphemeAnalysis();

					dao.save(app);
					dao.contentSave(app.getId(), analysis);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}