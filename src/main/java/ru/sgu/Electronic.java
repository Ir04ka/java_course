import java.util.Objects;

class Electronic extends Product {
    private int warrantyPeriod; // in months

    public Electronic(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Гарантия действует: " + warrantyPeriod + " месяцев";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Electronic that = (Electronic) obj;
        return warrantyPeriod == that.warrantyPeriod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyPeriod);
    }

    @Override
    public String toString() {
        return "Электроника{" + super.toString() + ", Гарантийиный период=" + warrantyPeriod + "}";
    }

    @Override
    public Electronic clone() {
        Electronic clonedElectronic = (Electronic) super.clone();
        return clonedElectronic;
    }

    @Override
    public Electronic deepClone() {
        Electronic clonedGroceries = new Electronic(new String(this.getName()), this.getPrice(), warrantyPeriod);
        return clonedGroceries;
    }
}