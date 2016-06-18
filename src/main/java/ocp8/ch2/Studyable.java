package ocp8.ch2;

/**
 * Created by roman.tsypuk on 6/18/16.
 */
@FunctionalInterface
public interface Studyable {
    void study(String examName);
}

class Student {
    private static void exam(Studyable exam, String examName) {
        exam.study(examName);
    }

    public static void main(String[] args) {
        exam(str ->
                System.out.println(str), "Mathematics"
        );
        exam((str) -> {
            System.out.println(str);
        }, "Informatics");
    }
}