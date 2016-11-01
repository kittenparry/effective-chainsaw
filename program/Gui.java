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

public class Gui extends JFrame{
	private Logger topper = new Logger();
	private JLabel item1, item2, item3, msg, time;
	private JButton butt4;
	private JTextField txt1, txt3, txt2;
	private int x = 1;
	private JRadioButton rad1;

	public Gui(){
		super("Log Recorder");
		setLayout(new FlowLayout());
		
		item1 = new JLabel("Directory:");
		txt1 = new JTextField("C:\\", 33);
		item2 = new JLabel("Filename:");
		txt3 = new JTextField("someFile");
		item3 = new JLabel("Entry:");
		txt2 = new JTextField(18);
		butt4 = new JButton("Enter");
		msg = new JLabel("");
		time = new JLabel("test");
		rad1 = new JRadioButton("", false);
		
		add(item1);
		add(txt1);
		add(item2);
		add(txt3);
		add(item3);
		add(txt2);
		add(butt4);
		add(time);
		add(msg);
		add(rad1);
		
		dandy hand = new dandy();
		timeH tim = new timeH();
		butt4.addActionListener(hand);
		txt2.addActionListener(hand);
		rad1.addItemListener(tim);
		rad1.hide();
		rad1.doClick();
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				txt2.requestFocus();
			}
		});
	}
	private class dandy implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			topper.logEntry(txt1.getText(), txt3.getText(), txt2.getText());
			if(topper.error == true){
				msg.setText("|| Error: Folder doesn't exist.");
			}else if(x > 1){
				msg.setText("|| Entry logged..");
				x = 1;
				txt2.setText("");
			}else{
				msg.setText("|| Entry logged.");
				x++;
				txt2.setText("");
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
