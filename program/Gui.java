import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui extends JFrame{
    private Logger topper = new Logger();
    private Locales str = new Locales();
    private JLabel item1, item2, item3, msg, time;
    private JButton butt4;
    private JTextField txt1, txt2, txt3;
    private int x = 1;
    private JRadioButton rad1;

    public Gui(){
        super();
        setLayout(new FlowLayout());
        str.Strings();
        setTitle(str.super_label);
        item1 = new JLabel(str.dir);
        //Enter the default directory to save .txt file here
        //Sub folders can be used directly
        //eg. "Users\\Public" if the program is located at C:\
        txt1 = new JTextField("C:\\Users\\Public", 33);
        item2 = new JLabel(str.file);
        //File name for the log file here
        txt2 = new JTextField("someFile", 4);
        item3 = new JLabel(str.entry);
        txt3 = new JTextField(18);
        butt4 = new JButton(str.button);
        msg = new JLabel("");
        time = new JLabel("");
        rad1 = new JRadioButton("", false);

        add(item1);
        add(txt1);
        add(item2);
        add(txt2);
        add(item3);
        add(txt3);
        add(butt4);
        add(time);
        add(msg);
        add(rad1);

        dandy hand = new dandy();
        timeH tim = new timeH();
        butt4.addActionListener(hand);
        txt3.addActionListener(hand);
        rad1.addItemListener(tim);
        rad1.hide();
        rad1.doClick();
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                txt3.requestFocus();
            }
        });
        //If you want to be able to change directory and filename on the go,
        //Enter true for the values below
        txt1.setEditable(false);
        txt2.setEditable(false);
    }
    private class dandy implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            topper.logEntry(txt1.getText(), txt2.getText(), txt3.getText());
            if(topper.error){
                msg.setText(str.error);
            }else if(x > 1){
                msg.setText(str.log1);
                x = 1;
                txt3.setText("");
            }else{
                msg.setText(str.log2);
                x++;
                txt3.setText("");
            }
        }
    }
    public class timeH implements ItemListener{
        public void itemStateChanged(ItemEvent ev){
            time.setText(topper.createTime());
            System.out.println(topper.createTime());
            Thread time1 = new Thread(new TimeC());
            time1.start();
        }
    }
    public class TimeC implements Runnable{
        public void run(){
            try{
                Thread.sleep(333);
                for(int i = 0; i < 3000; i++){
                    time.setText(topper.createTime());
                    Thread.sleep(333);
                }
                this.run();
            }catch(Exception e){
                System.out.println("timer not working");
            }
        }
    }
}
