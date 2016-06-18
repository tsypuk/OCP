package ocp8.ch1;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
public class EnumInSwitch {
    public static void main(String[] args) {
        EnumString code = EnumString.OK;
        switch (code) {
            case OK:
                System.out.println("OK");
                break;
            case NOT_FOUND:
                System.out.println("NOT");
                break;
//            Error:(16, 28) java: an enum switch case label must be the unqualified name of an enumeration constant

//            case EnumString.NOT_FOUND:
//                break;
        }

        for (EnumString enumString : EnumString.values()) {
            System.out.println(enumString.name() + " " + enumString.ordinal());
            System.out.println(enumString);
        }

        EnumString ok = EnumString.valueOf("OK");
//        Exception in thread "main" java.lang.IllegalArgumentException: No enum constant ocp8.ch1.EnumString.ok
//        at java.lang.Enum.valueOf(Enum.java:238)
//        EnumString ok2 = EnumString.valueOf("ok");
    }
}