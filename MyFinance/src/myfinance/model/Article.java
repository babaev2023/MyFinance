
package myfinance.model;

import java.util.Objects;
import myfinance.exception.ModelException;

/**
 *
 * @author Stepan Babaev
 */
public class Article extends Common{
    private String title;
    
    public Article() {}
    
    public Article(String title) throws ModelException{
        if (title.length()==0) throw new ModelException(ModelException.TITLE_EMPTY);
        this.title = title;
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" + "title=" + title + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        return Objects.equals(this.title, other.title);
    }
    
    @Override
     public String getValueForComboBox() {
         return title;
     }
}