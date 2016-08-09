package skurski.solr.model;


public class Searching {

    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Searching{" +
                "keywords='" + keywords + '\'' +
                '}';
    }
}
