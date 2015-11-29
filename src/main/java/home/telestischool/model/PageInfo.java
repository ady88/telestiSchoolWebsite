package home.telestischool.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author adrian
 */
@Entity
@Table(name = "pageinfo")
public class PageInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String language;

    @Column(name = "url_info")
    private String urlInfo;

    public PageInfo() {
    }

    public PageInfo(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    @Override
    public String toString() {
        return "PageInfo{" + "name=" + name + ", language=" + language + ", urlInfo=" + urlInfo + '}';
    }
}
