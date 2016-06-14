package kr.co.kau.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "keywords")
public class KeywordVO {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;
    
    private String keword;
   
    private int count;
    
    @ManyToOne
    private ApplicationVO app;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKeword() {
		return keword;
	}

	public void setKeword(String keword) {
		this.keword = keword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ApplicationVO getApp() {
		return app;
	}

	public void setApp(ApplicationVO app) {
		this.app = app;
	}

	@Override
	public String toString() {
		return "AContentVO [id=" + id + ", keword=" + keword + ", count=" + count +  "]";
	}
	
}
