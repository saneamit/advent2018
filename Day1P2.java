import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.util.*;

public class Day1P2 {

    public void AdventDay1P2(String line) {
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
            m_lines = m_lines + 1;
        }
        else if (strSign.charAt(0) == '+')
        {
            m_sum += Long.parseLong(strValue);
            m_lines = m_lines + 1;
        }
        else
        {
            System.out.println("Incorrect string input" + line);
        }
    }

    public long GetSum() { return m_sum; }
    public long GetLineCount() { return m_lines; }

  public static void main(String[] pArgs) throws IOException {
    String fileName = "Day1P1Sample.txt";
    File file = new File(fileName);
    Day1P2 day1P2 = new Day1P2();
    HashSet<Long> hsetSum = new HashSet<Long>();
    long init = 0;
    hsetSum.add(init);

    try (Stream linesStream = Files.lines(file.toPath())) {
      linesStream.forEach(line -> {
        day1P2.AdventDay1P2(line.toString());        
        if (!hsetSum.add(day1P2.GetSum()))
        {
            System.out.println("duplicate freq [" + day1P2.GetSum() + "]");
            return;
        }        
      });
    }

    System.out.println("No duplicates found " + hsetSum.size() + " " + day1P2.GetLineCount());
    
  }

  private long m_sum = 0;
  private long m_lines = 0;
}