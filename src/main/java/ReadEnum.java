import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rtsy on 07.03.2016.
 */
public class ReadEnum {
    public static void main(String[] args)
            throws IOException {
        Files.lines(Paths.get("D:\\svnwork\\prr\\trunk\\working\\product\\core\\model\\src\\main\\java\\com\\bazaarvoice\\cca\\report\\ReportType.java"))
                .filter(str -> str.contains("(Permission."))
                .map(str -> "'" + str.substring(0, str.indexOf('(')).trim() + "', ")
                .forEach(System.out::print);
    }
}
