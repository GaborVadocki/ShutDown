package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;

import net.miginfocom.swing.MigLayout;
import Actions.ActionExit;
import Actions.ActionReset;
import Actions.ActionStart;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{

	JLabel lNaziv = new JLabel("Unesite delay za shootdown");
	JButton btnStart = new JButton("Start");
	//btnStart.setSize(50, 50);
	JButton btnReset = new JButton("Reset");
	JButton btnExit = new JButton("Exit");
	JLabel lVreme = new JLabel("0");
	JLabel lTekst = new JLabel("Preostalo vreme:");
	JTextField jBrojac = new JTextField("",15);
	
	Timer timer;
	
	MaskFormatter mf1;
	JFormattedTextField jftf;
	
	public String getJtft(){return jftf.getText(); }
	
	public String getJBrojac(){return jBrojac.getText();
			}
	
	public MainFrame() throws ParseException{
		JPanel myPanel = new JPanel();
		
		GridLayout glo = new GridLayout(0,2);
		
		this.setTitle("Naslov testa");
		this.setSize(500, 300);
		
		//btnExit.setSize(new Dimension(1000,150));
		btnExit.setMinimumSize(new Dimension(75,30));
	//	btnExit.setMaximumSize(new Dimension(75,30));
		//setSize(40,330);
		myPanel.setLayout(new MigLayout());
		
		add(myPanel);
		
		mf1 = new MaskFormatter("##:##:##");
		jftf = new JFormattedTextField(mf1);
		
		jftf.setMinimumSize(new Dimension(60, 30));
		
		jftf.setText("000000");
		
		lVreme.setFont(lVreme.getFont().deriveFont(64.0f));
		lTekst.setFont(lTekst.getFont().deriveFont(24.0f));
		//jBrojac.s
		//jBrojac.setLayout(null);
	//	jBrojac.setSize(100, 100);
		
		myPanel.add(lNaziv,"wrap");
		//myPanel.add(jBrojac);
		myPanel.add(jftf);
		myPanel.add(btnStart);
		myPanel.add(btnReset);
		myPanel.add(btnExit,"wrap");
		myPanel.add(lTekst);
		myPanel.add(lVreme,"span 4");
		
		ActionStart actStart = new ActionStart(this);
		ActionExit actExit = new ActionExit(this);
		ActionReset actReset = new ActionReset(this);
		
		btnStart.addActionListener(actStart);
		btnExit.addActionListener(actExit);
		btnReset.addActionListener(actReset);
		
		
		
		
		this.setVisible(true);
	}
	
	public void setLVreme(String s){
		lVreme.setText(s);
	}
	
	public void setJtft(String s){
		jftf.setText(s);
	}
	
	public static void main(String[] args){
		
		try {
			MainFrame mf = new MainFrame();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		mf.setVisible(true);
	}
	
}
