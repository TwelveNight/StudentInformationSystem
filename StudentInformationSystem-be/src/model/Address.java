package util;

/**
 * 地址类，包括省份、城市、街道、门牌号四个属性
 */
public class Address {
    private String province;  // 省份
    private String city;  // 城市
    private String street;  // 街道
    private String number;  // 门牌号

    /**
     * 构造函数
     *
     * @param province 省份
     * @param city     城市
     * @param street   街道
     * @param number   门牌号
     */
    public Address(String province, String city, String street, String number) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    // 各属性的get、set方法
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 重写toString方法，返回完整地址字符串
     *
     * @return 完整地址字符串
     */
    @Override
    public String toString() {
        return province + " " + city + " " + street + " " + number;
    }
}
