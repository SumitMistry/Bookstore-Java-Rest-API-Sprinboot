package Springboot.Bookstore.Model;

public class CategoryModel {

    String categoryName;
    int cat_id;

    public CategoryModel(String categoryName, int cat_id) {
        this.categoryName = categoryName;
        this.cat_id = cat_id;
    }

    public String getName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryName='" + categoryName + '\'' +
                ", cat_id=" + cat_id +
                '}';
    }
}
