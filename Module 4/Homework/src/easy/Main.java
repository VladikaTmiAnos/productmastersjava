package easy;

public class Main {

  public static void main(String[] args) {
    StringPrinter printer = new StringPrinter();
    printer.print("Hello, world!");
  }

}
interface Printer<T> {
  void print(T value);
}
class StringPrinter implements Printer<String> {
  @Override
  public void print(String value) {
    System.out.println(value);
  }
}
