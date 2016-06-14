package kr.co.kau.analsys;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

public class MorphemeAnalysor {
	private String aContent;
	
	public MorphemeAnalysor(String aContent) {
		this.aContent = aContent;
	}

	public Map<String,Integer> morphemeAnalysis(){
		Komoran komoran = new Komoran("src/main/resources/models-full");
		
		List<List<Pair<String,String>>> result = komoran.analyze(aContent.trim());
		Map<String,Integer> map= Maps.newHashMap();
		
		for (List<Pair<String, String>> eojeolResult : result) { 
			for (Pair<String, String> wordMorph : eojeolResult) {
				if(wordMorph.getSecond().equals("NNP")||wordMorph.getSecond().equals("NNG")||wordMorph.getSecond().equals("SL")){
					int count =0;
					if(map.containsKey(wordMorph.getFirst())){
						count = map.get(wordMorph.getFirst());
					}
					map.put(wordMorph.getFirst(), ++count);
				}
//				System.out.println(wordMorph);
			}  
		}
		
/*		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) { 
			String key = (String)iterator.next(); // 키 얻기
			System.out.println("key="+key+" / value="+map.get(key));  // 출력
		}*/
		
		return map;
	}
}
