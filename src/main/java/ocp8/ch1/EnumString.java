package ocp8.ch1;

/**
 * Created by roman.tsypuk on 6/6/16.
 */
public enum EnumString {

    NOT_FOUND("403"), OK("200");
    //semicolon is required

    private String value;

//    Error:(13, 12) java: modifier public not allowed here. Only private is allowed.
    private EnumString(String value) {
        this.value = value;
        System.out.println(value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}