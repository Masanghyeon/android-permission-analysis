package kr.co.kau;

import kr.co.kau.service.ApplicationDAO;

public class GooglePlayParserMain {
	public static void main(String[] args) {
		System.out.println("Start parser.....");

				
		//Google Play Web Crowling
		//new GooglePlayParser().googlePlayParsing();
		
		new ApplicationDAO().permission();
		
	}
}
