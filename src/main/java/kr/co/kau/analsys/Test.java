package kr.co.kau.analsys;

public class Test {
	public void test(){
/*		// string to analyze
		String string = "�ѱ��װ����б� �л����� ���Ͽ� ��� ��η� ������ ���ø����̼��Դϴ�."+
				"�б� �ֿ� ���� �� ���߱��� �� �پ��� ���񽺸� �����մϴ�."+
				"���л��� �������μ� ���ߴ� ��ɵ��� �ִ��� ��ƺ��ҽ��ϴ�."+
				"1. ������ �¼� ���� Ȯ�� : �ǽð� ������ �¼� ��Ȳ ����"+
				"2. ���� �Ĵ� �Ĵ�ǥ Ȯ�� : �� �Ĵ纰 �Ĵ�ǥ ����"+
				"3. �ֺ� ��� ���� ��Ȳ : �� ��� ������ �޴��� �� �ֹ����� ����"+
				"4. ���� �Խ��� : ������ �����Ӱ� �ۼ��� �� �ִ� �Խ��� ����"+
				"5. �ֺ� ���� ���� ( ����, ����ö ) : ȭ���� �� ���� �ֺ� ���� ������ ���� ����"+
				"6. ���� �ֿ� ���� ���� : ���� �ֿ� ���� ���� (KAU MAP)"+
				"�˻��� : sansil-e �ѱ��װ����б� �ѱ��װ��� �װ��� kau";

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