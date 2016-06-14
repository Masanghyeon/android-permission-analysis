package kr.co.kau;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Maps;

public class PermissionInfo{
	private static String sports[] = {"cc.pacer.androidapp",
			"com.popularapp.sevenmins",
			"com.tinymission.dailyworkoutsfree",
			"com.popularapp.abdominalexercise",
			"com.donets.dietplan",
			"kr.co.igrove.gymday",
			"com.wearablelab.fitnessmate",
			"com.northpark.squats",
			"com.dailyyoga.inc",
			"com.fatsecret.android"
	};

	private static String education[] = {"com.nhn.android.naverdic",
			"com.imcompany.school2",
			"com.coden.android.ebs",
			"com.joysoft.wordBook",
			"co.riiid.sledge",
			"kr.co.tamseng.StudyHelper",
			"air.com.nhncorp.jrapp",
			//			"com.kr.nglms", //empty
			"com.mcnc.parecis.hrdkorea.qnet",
			"com.hackers.app"
	};

	private static String transporation [] ={"com.kakao.taxi",
			"com.locnall.KimGiSa",
			"teamDoppelGanger.SmarterSubway",
			"com.skplanet.tmaplink",
			"teamdoppelganger.smarterbus",
			"com.thinkware.inaviair",
			"com.kscc.scxb.mbl",
			"com.astroframe.seoulbus",
			"kt.navi",
			"com.imagedrome.jihachul"
	};

	private static String finance [] ={"com.kbstar.starpush",
			"kr.co.hanamembers.hmscustomer",
			"com.shcard.smartpay",
			"nh.smart",
			"kvp.jjy.MispAndroid320",
			"com.kbstar.kbbank",
			"com.wr.alrim",
			"viva.republica.toss",
			"com.wooribank.pib.smart",
			"com.shinhan.sbanking"
	};

	private static String weather [] ={"com.softworx.cai",
			"cheehoon.ha.particulateforecaster",
			"wongi.weather",
			"or.kr.airkorea.dq",
			"teamjj.tools.weather_nara",
			"mobi.infolife.ezweather",
			"com.droid27.transparentclockweather",
			"com.apalon.weatherlive.free",
			//			"com.stylistbong.airclean",  //empty
			"com.devexpert.weather"
	};

	private static String news[]={"com.estsoft.android.ytn",
			"com.jtbc.news",
			"kr.co.kbs.news301",
			"kr.psynet.yhnews",
			"com.cubeflux.news",
			"com.imbc.imnews.mbcnews",
			"bbc.mobile.news.ww",
			"com.mk.news",
			"com.chosunmedia.android",
			"Hani.nemo.huyu"			
	};

	private static String comics[]={"com.nhn.android.webtoon",
			"net.daum.android.webtoon",
			"com.lezhin.comics",
			"com.whalegames.app",
			"com.toast.comico",
			"com.zzangcartoon20",
			"com.olleh.olltoon",
			"com.andromu.ztcomics",
			"com.mycomiczul.t140905",
			"com.nate.android.cartoon"
	};

	private static String video[]={"com.nhn.android.naverplayer",
			"kr.co.nowcom.mobile.afreeca",
			"com.skb.btvmobile",
			"kr.co.captv.pooqV2",
			"net.daum.android.tvpot",
			"com.everyontv",
			"com.kt.otv",
			"com.kmplayer",
			"com.gretech.gomplayerko",
			"kr.co.sbs.videoplayer"
	};

	private static String photographic[]={"com.zentertain.photoeditor",
			"com.pipcamera.activity",
			"com.lyrebirdstudio.montagenscolagem",
			"com.picsart.studio",
			"com.hantor.CozyCamera",
			"com.linecorp.b612.android",
			"com.peace.SilentCamera",
			"com.joeware.android.gpulumera",
			"photo.camera.hdcameras",
			"vStudio.Android.Camera360"
	};
	private static enum apks{
		SPORTS(sports),EDUCATION(education),
		TRANSPORATION(transporation),FINANCE(finance),WEATHER(weather),
		NEWS(news),COMICS(comics),VIDEO(video),PHOTOGRAPHIC(photographic);

		String[] name;
		apks(String[] name){
			this.name=name;
		}
		String []getApk(){
			return name;
		}
	};

	public static void main(String[] args) {
		for(apks apk:apks.values()){
			Map<String,Integer> map= Maps.newHashMap();
			System.out.println(apk.name());
			System.out.println("=====================");
			for(String path:apk.getApk()){
				System.out.print(path + " ");
				/*
				try{
					ProcessBuilder pb = new ProcessBuilder("/Program Files/java/jdk1.8.0_45/bin/java", "-jar", "C:/apktool.jar","d","C:/Application/"+apk.name()+"/"+path+".apk");
					Process p = pb.start();
					BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
					String line = null;
					while((line = reader.readLine()) != null) {
						System.out.print(line + "\n");
					}
					reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
					line = null;
					while((line = reader.readLine()) != null) {
						System.out.print(line + "\n");
					}
					p.waitFor(); 
				}catch(Exception e){
					e.printStackTrace();
				}*/
				File manifest = new File("C:/workspace/android-permission-analysis/"+path+"/AndroidManifest.xml");
				Document doc;
				System.out.print("|");
				try {
					doc = Jsoup.parse(manifest, "UTF-8");
					Elements datas = doc.select("uses-permission");
					String permission = null;
					for(Element data : datas){
						if(data.attr("android:name").startsWith("android.permission.")){
							permission = data.attr("android:name").substring(19);							
							System.out.print(", "+permission);
							/*int count =0;
							if(map.containsKey(permission)){
								count = map.get(permission);
							}
							map.put(permission, ++count);*/
						}
					}
					System.out.println("");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = (String)iterator.next(); // 키 얻기
				System.out.println(map.get(key)+"/"+key);  // 출력
			}
		}

	}
}