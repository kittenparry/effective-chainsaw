import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.WindowConstants;

public class Logger {
    public boolean error = false;
    public static void main(String args[]){
        Gui g = new Gui();
        g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        g.setSize(450, 125);
        g.setVisible(true);
    }
    public void logEntry(String dir, String name, String txt){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(dir + "/" + name + ".txt", true)))) {
            error = false;
            out.println(createTime() + "| " + txt);
        }catch (IOException e) {
            error = true;
            System.out.println("error");
        }
    }
    public String createTime(){
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        //Uncomment below to set a timezone
        //if the time doesn't show up correctly
        //ft.setTimeZone(TimeZone.getTimeZone("GMT"));
        return ft.format(date);
    }
}
