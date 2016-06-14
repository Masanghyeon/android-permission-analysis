package kr.co.kau.analsys;

public class Test {
	public void test(){
/*		// string to analyze
		String string = "한국항공대학교 학생들을 위하여 재능 기부로 개발한 어플리케이션입니다."+
				"학교 주요 정보 및 대중교통 등 다양한 서비스를 제공합니다."+
				"재학생의 입장으로서 원했던 기능들을 최대한 담아보았습니다."+
				"1. 도서관 좌석 정보 확인 : 실시간 도서관 좌석 현황 제공"+
				"2. 교내 식당 식단표 확인 : 각 식당별 식단표 제공"+
				"3. 주변 배달 음식 현황 : 각 배달 음식점 메뉴판 및 주문정보 제공"+
				"4. 자유 게시판 : 누구나 자유롭게 작성할 수 있는 게시판 제공"+
				"5. 주변 교통 정보 ( 버스, 지하철 ) : 화전역 및 교내 주변 버스 정류장 정보 제공"+
				"6. 교내 주요 정보 제공 : 교내 주요 정보 제공 (KAU MAP)"+
				"검색어 : sansil-e 한국항공대학교 한국항공대 항공대 kau";

				// init MorphemeAnalyzer
				MorphemeAnalyzer ma = new MorphemeAnalyzer();
				try{
					// create logger, null then System.out is set as a default logger
					ma.createLogger(null);

					// analyze morpheme without any post processing 
					List ret = ma.analyze(string);

					// refine spacing
					ret = ma.postProcess(ret);

					// leave the best analyzed result
					ret = ma.leaveJustBest(ret);

					// divide result to setences
					List stl = ma.divideToSentences(ret);
					// print the result
					for( int i = 0; i < stl.size(); i++ ) {
						Sentence st = (Sentence) stl.get(i);
						System.out.println("===>  " + st.getSentence());
						for( int j = 0; j < st.size(); j++ ) {
							System.out.println(st.get(j));
						}
					}
					// string to extract keywords
					String strToExtrtKwrd = string;

					// init KeywordExtractor
					KeywordExtractor ke = new KeywordExtractor();

					// extract keywords
					KeywordList kl = ke.extractKeyword(strToExtrtKwrd, true);
					
					// print result
					for( int i = 0; i < kl.size(); i++ ) {
						Keyword kwrd = kl.get(i);
						System.out.println(kwrd.getString() + "\t" + kwrd.getCnt());
					}
				}catch(Exception e){
					e.printStackTrace();
				}

				ma.closeLogger();*/
	}
}