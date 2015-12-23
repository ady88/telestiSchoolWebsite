package home.telestischool.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author adrian
 */
@Entity
@Table(name = "pagenews")
public class PageNews implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public PageNews(long id, String namePage, String headline, String content, Date addDate, String language) {
        this.id = id;
        this.namePage = namePage;
        this.headline = headline;
        this.content = content;
        this.addDate = addDate;
        this.language = language;
    }

    @Column(name = "name_page")
    private String namePage;

    private String headline;

    private String content;

    @Column(name = "add_date")
    @Temporal(DATE)
    private Date addDate;

    private String language;

    public PageNews() {
    }

    public PageNews(String namePage, String headline, String language) {
        this.namePage = namePage;
        this.headline = headline;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getNamePage() {
        return namePage;
    }

    public String getHeadline() {
        return headline;
    }

    public String getContent() {
        return content;
    }

    public Date getAddDate() {
        return addDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNamePage(String namePage) {
        this.namePage = namePage;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "PageNews{" + "namePage=" + namePage + ", headline=" + headline + ", language=" + language + '}';
    }

}
