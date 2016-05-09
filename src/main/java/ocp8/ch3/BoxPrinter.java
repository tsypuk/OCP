package ocp8.ch3;

/**
 * Created by rtsy on 05.03.2016.
 */
public class BoxPrinter<T> {
    private T value;

    public BoxPrinter(T arg) {
        value = arg;
    }

    @Override
    public String toString() {
        return "[" + value + "]";
    }
}

class BoxPrinterSample {
    public static void main(String[] args) {
        BoxPrinter<String> stringBoxPrinter = new BoxPrinter<>("Test string");
        System.out.println(stringBoxPrinter);

        BoxPrinter<Integer> integerBoxPrinter = new BoxPrinter<>(33);
        System.out.println(integerBoxPrinter);

//        BoxPrinter<Integer> testBoxPrinter = new BoxPrinter<String>("aaa");
//        Error:(27, 46) java: incompatible types: ocp8.ch3.BoxPrinter<java.lang.String>
//        cannot be converted to ocp8.ch3.BoxPrinter<java.lang.Integer>
        BoxPrinter<String> rawBox = new BoxPrinter("Hello");
//        Warning:(30, 37) java: unchecked call to BoxPrinter(T) as a member of the raw type ocp8.ch3.BoxPrinter
//        Warning:(30, 37) java: unchecked conversion
//        required: ocp8.ch3.BoxPrinter<java.lang.String>
//        found:    ocp8.ch3.BoxPrinter
    }
}