package ND2.picaOrder;

class Pizza {

    private Size size;
    private Integer cheese;
    private Integer peperoni;

    public Pizza(Size size, Integer cheese, Integer peperoni) {
        this.size = size;
        this.cheese = cheese;
        this.peperoni = peperoni;
    }

    Integer calculatePrice() {
        Integer sum = 0;
        switch (size) {
            case BIG -> sum += 14;
            case MID -> sum += 12;
            case SMALL -> sum += 11;
        }
        return sum + cheese * 2 + peperoni * 2;
    }

    enum Size {
        SMALL,
        MID,
        BIG
    }
}