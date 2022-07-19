
class GenericsTest<T, U> {

    private T object;
    private U object2;

    public GenericsTest(T object, U object2) {
        this.object = object;
        this.object2 = object2;
    }

    public T getObject() {
        return object;
    }

    public U getObject2() {
        return object2;
    }

    public void print(){
        System.out.println("Object type: " + object.getClass() +", value: " + getObject());
        System.out.println("Object type: " +object2.getClass() +", value: " + getObject2());
    }

}
