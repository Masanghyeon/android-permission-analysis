package kr.co.kau.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="app_inform")
public class ApplicationVO {
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	private long id;
	private String aTitle;
	private String aCategory;
	private String aUrl;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<KeywordVO> aKeyword;
//	private String [] aPermissions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getaTitle() {
		return aTitle;
	}

	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}

	public String getaCategory() {
		return aCategory;
	}

	public void setaCategory(String aCategory) {
		this.aCategory = aCategory;
	}

	public String getaUrl() {
		return aUrl;
	}

	public void setaUrl(String aUrl) {
		this.aUrl = aUrl;
	}

	public Set<KeywordVO> getaKeyword() {
		return aKeyword;
	}

	public void setaKeyword(Set<KeywordVO> aKeyword) {
		this.aKeyword = aKeyword;
	}

	@Override
	public String toString() {
		return "ApplicationVO [id=" + id + ", aTitle=" + aTitle + ", aCategory=" + aCategory + ", aUrl=" + aUrl
				+ "]";
	}
	
}
