import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class Day1P1 {

    public void AdventDay1P1(String line) {
        if (line.length() < 2)
        {
            System.out.println("Incorrect string size input" + line);
            return;
        }
        String strSign = line.substring(0,1);
        String strValue = line.substring(1);
        if (strSign.charAt(0) == '-')
        {
            m_sum -= Long.parseLong(strValue);
        }
        else if (strSign.charAt(0) == '+')
        {
            m_sum += Long.parseLong(strValue);
        }
        else
        {
            System.out.println("Incorrect string input" + line);
        }
    }

    public long GetSum() { return m_sum; }

  public static void main(String[] pArgs) throws IOException {
    String fileName = "Day1P1Sample.txt";
    File file = new File(fileName);
    Day1P1 day1P1 = new Day1P1();
    try (Stream linesStream = Files.lines(file.toPath())) {
      linesStream.forEach(line -> {
        day1P1.AdventDay1P1(line.toString());
      });
    }

    System.out.println(day1P1.GetSum());
  }

  private long m_sum = 0;
}