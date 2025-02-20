package hard;

class Box<T> {
  private T item;
  public Box(T item) {
    this.item = item;
  }
  public void setItem(T item) {
    this.item = item;
  }

  public T getItem() {
    return item;
  }

  public void showType() {
    System.out.println("Тип объекта: " + item.getClass().getName());
  }

  public static void main(String[] args) {
    Box<String> stringBox = new Box<>("Привет, мир!");
    System.out.println("Содержимое: " + stringBox.getItem());
    stringBox.showType();
    class MyData {
      private int value;
      public MyData(int value) {
        this.value = value;
      }
      @Override
      public String toString() {
        return "MyData: " + value;
      }
    }

    Box<MyData> dataBox = new Box<>(new MyData(42));
    System.out.println("Содержимое: " + dataBox.getItem());
    dataBox.showType();
  }
}
