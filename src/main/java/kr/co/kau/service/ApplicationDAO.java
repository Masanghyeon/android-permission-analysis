package kr.co.kau.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import kr.co.kau.model.ApplicationVO;
import kr.co.kau.model.KeywordVO;
import kr.co.kau.model.PermissionVO;
import kr.co.kau.model.Permissions;
import kr.co.kau.utils.HibernateUtils;

public class ApplicationDAO {

	private SessionFactory sessionFactory;

	public ApplicationDAO() {
		try {
			sessionFactory = HibernateUtils.createSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void permission(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		PermissionVO permissionvo;
		for (Permissions permission: Permissions.values()) {
			permissionvo = new PermissionVO();
			System.out.println(permission.name());
			permissionvo.setName(permission.name());
			session.save(permissionvo);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void permissionCount(String permission){
/*		Session session = sessionFactory.openSession();
		session.beginTransaction();
		PermissionVO permissionvo = session.
		int count = permissionvo.getCount();
		permissionvo.setCount(++count);
		session.save(permissionvo);
		session.getTransaction().commit();
		session.close();*/
	}

	public void save(ApplicationVO app){
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println(app.toString());
		session.save(app);

		session.getTransaction().commit();
		session.close();
	}

	public void get(long app_id){
		Session session = sessionFactory.openSession();
		ApplicationVO app = session.get(ApplicationVO.class, app_id);

		Iterator<KeywordVO> keywords = app.getaKeyword().iterator();

		while(keywords.hasNext()){                           
			System.out.println(keywords.next().toString());
		}
		System.out.println(app.toString());
	}

	public void contentSave(long app_id,Map<String,Integer> analysis){
		Session session = sessionFactory.openSession();	
		ApplicationVO vo = session.get(ApplicationVO.class, app_id);
		session.beginTransaction();
		Iterator<String> iterator = analysis.keySet().iterator();

		while (iterator.hasNext()) {
			KeywordVO keywordvo = new KeywordVO();

			String key = (String)iterator.next(); // Å° ¾ò±â
			keywordvo.setKeword(key);
			keywordvo.setCount(analysis.get(key));
			keywordvo.setApp(vo);

			vo.getaKeyword().add(keywordvo);

			session.save(keywordvo);
		}

		session.getTransaction().commit();
		session.close();
	}
}