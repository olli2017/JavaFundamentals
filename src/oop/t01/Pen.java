package oop.t01;

public class Pen {
    private String company;
    private String colors;
    private int price;

    public Pen(String company, String colors, int price) {
        this.company = company;
        this.colors = colors;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pen)) return false;

        Pen pen = (Pen) o;

        if (price != pen.price) return false;
        if (!company.equals(pen.company)) return false;
        return colors.equals(pen.colors);
    }

    @Override
    public int hashCode() {
        int result = company.hashCode();
        result = 31 * result + colors.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "company='" + company + '\'' +
                ", colors='" + colors + '\'' +
                ", price=" + price +
                '}';
    }

}
