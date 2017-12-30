package inn.shopping.api.entity;

public class GoodsAttributeItemsRelation {
    private Integer id;
    private String goodsId;
    private String attributerItemId;
    private String defaultItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getAttributerItemId() {
        return attributerItemId;
    }

    public void setAttributerItemId(String attributerItemId) {
        this.attributerItemId = attributerItemId == null ? null : attributerItemId.trim();
    }

    public String getDefaultItem() {
        return defaultItem;
    }

    public void setDefaultItem(String defaultItem) {
        this.defaultItem = defaultItem == null ? null : defaultItem.trim();
    }
}