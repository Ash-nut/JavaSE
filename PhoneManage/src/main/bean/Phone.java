package main.bean;

import java.text.SimpleDateFormat;

/**
 * 特别需要注意的，在这里我设置了两个带参构造
 * 一个是带 changeDate 的，这个用于后续的操作；因为操作过后就要更改了嘛；
 * 另一个是自动生成 changeDate 的用于新建的，新建之后自动更新这个录入时间的
 */
public class Phone{
    private String id;
    private String name;
    private int price;
    private int quantityInStock;
    private String changeDate;
    private String brand;

    private Phone() {
    }
    public Phone(String id, String name, int price, int quantityInStock, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.brand = brand;
        changeDate = new SimpleDateFormat("yyyy-MM-dd").toString();
    }

    public Phone(String id, String name, int price, int quantityInStock, String changeDate, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.changeDate = changeDate;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(SimpleDateFormat changeDate) {
        this.changeDate = String.valueOf(changeDate);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", changeDate='" + changeDate + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
    public int comepareToPrice(Phone phone){
        return (int) (this.price-phone.getPrice());
    }
    public int comepareToQuantityInStock(Phone phone){
        return (this.quantityInStock-phone.getQuantityInStock());
    }
}
