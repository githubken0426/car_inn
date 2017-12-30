package inn.shopping.api.entity;

import java.util.List;

public class GoodsAttribute {
    private String id;
    private String categoryId;
    private String name;
    private String fullName;
    private Integer sort;
    private String description;
    private List<GoodsAttributeItems> items;//属性选项

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public List<GoodsAttributeItems> getItems() {
		return items;
	}

	public void setItems(List<GoodsAttributeItems> items) {
		this.items = items;
	}
}