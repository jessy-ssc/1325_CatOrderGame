import java.util.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.Graphics;

public class maingame {
	JFrame window;
	//creates window
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, menuPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, timeLabel, timeLabelnum;
	JLabel coffee, latte, espresso, cake, cookie, muffin, mnum, item;
	Font titleFont = new Font("Comic Sans MS", Font.PLAIN, 80);
    //font & size for title
	Font normalFont = new Font("Comic Sans MS", Font.PLAIN, 28);
    //font & size for text
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP;
	String position;
	String a;
	int b;

	JTextAreaPlus textAreaPlus;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	ImageIcon logo = new ImageIcon("caticon1.jpg");
	//Icon for game


	public static void main(String[] args) {

		new maingame();
	}
	
	public maingame(){
		window = new JFrame();
		window.setSize(800, 600);
		//size of window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//editing
		window.getContentPane().setBackground(null);
		//background color for title and game
		window.setLayout(null);
		window.setIconImage(logo.getImage());
		//adds icon for game
		//add cat icon
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		//editing
		titleNamePanel.setBackground(Color.orange);
		//color for title panel
		//set same as backfground color
		titleNameLabel = new JLabel("Cat Order Game");
		titleNameLabel.setForeground(Color.black);
        //color for title text
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 165, 50);
		//editing
		startButtonPanel.setBackground(Color.orange);
		//color for clock-in panel
		//set same as backfground color
		
		startButton = new JButton("CLOCK IN");
		startButton.setBackground(Color.orange);
        //background color of start button
		startButton.setForeground(Color.black);
        //color of text for start button
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);

		//background image
		textAreaPlus = new JTextAreaPlus();
		textAreaPlus.setSize(800, 600);
		textAreaPlus.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		ImageIcon back = new ImageIcon(getClass().getClassLoader().getResource("catcafe.jpg"));
		textAreaPlus.setImage(back,0,0,800,600);
		textAreaPlus.setForeground(null);


		window.add(textAreaPlus);
		//background imagge
		
		window.setVisible(true);
		//end of title screen
	}
	//part of code for background image
	public class JTextAreaPlus extends JTextArea{
	
		Image image;
		int x, y, width, height;
	
		public JTextAreaPlus() {
			super();
		}
		public JTextAreaPlus(String text) {
			super(text);
		}
		
		public void setImage(ImageIcon icon, int x, int y, int width, int height) {
			
			this.image = icon.getImage();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			setOpaque(false);
			repaint();
		}
		public void paint(Graphics g) {
			
			g.drawImage(image,x,y,width,height,null);	
			super.paint(g);
		}
	}
	//end of background image code
	public void createGameScreen(){
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.orange);
        //set same as backfground color(orange)
		con.add(mainTextPanel);		
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.white);
        //background color for main text
		mainTextArea.setForeground(Color.black);
        //main text color
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true); 
		mainTextArea.setEditable(false); 	
		
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(null);
        //background color for choice panel
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.white);
		//
		choice1.setForeground(Color.black);
		//choice text color
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler); 
		choice1.setActionCommand("c1"); 
		choiceButtonPanel.add(choice1);
		//end of option 1

		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.white);
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		//end of option 2

		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.white);
		choice3.setForeground(Color.black);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		//end of option 3

		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.white);
		choice4.setForeground(Color.black);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		//end of option 4
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.white);
		//color for player panel
		playerPanel.setLayout(new GridLayout(1, 4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.black);
		//hp color text
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.black);
		//hp num color
		playerPanel.add(hpLabelNumber);
		timeLabel = new JLabel("TIMER:");
		timeLabel.setFont(normalFont);
		timeLabel.setForeground(Color.black);
		//time text color
		playerPanel.add(timeLabel);
		timeLabelnum = new JLabel();
		timeLabelnum.setFont(normalFont);
		timeLabelnum.setForeground(Color.black);
		//time num color
		playerPanel.add(timeLabelnum);

		playerSetup();

	}
	String cc1, cc2;
	String ic1, ic2;
	String rndmElem_one, rndmElem_two, rndmElem_three, rndmElem_four;
	int score;
	
	//randomizer for customer item
	public void randomizer(){
		 // Creating arraylist 
		 ArrayList<String> araylist = new ArrayList<String>();
		 // Adding elements in arraylist
		 araylist.add("Plain Coffee");
		 araylist.add("Latte");
		 araylist.add("Espresso");
		 araylist.add("Cake Slice");
		 araylist.add("Muffin");
		 araylist.add("Cookie");
  
		Random rndm = new Random();
  
		rndmElem_one = araylist.get(rndm.nextInt(araylist.size()));
		araylist.remove(rndmElem_one);
  
		rndmElem_two = araylist.get(rndm.nextInt(araylist.size()));
		araylist.remove(rndmElem_two);

		rndmElem_three = araylist.get(rndm.nextInt(araylist.size()));
		araylist.remove(rndmElem_three);
  
		rndmElem_four = araylist.get(rndm.nextInt(araylist.size()));
		araylist.remove(rndmElem_four);
  
		ic1 = rndmElem_one;
		cc1 = rndmElem_two;
		cc2 = rndmElem_three;
		ic2 = rndmElem_four;
	}
	//subtracter for picking wrong choice
	public void subh(){
		playerHP = playerHP- 10;
		hpLabelNumber.setText(""+playerHP);
	}
	//addition for choosing correct option
	public void as(){
		score = score + 25;
	}
	//setup for player hp 
	public void playerSetup(){
		playerHP = 50;
		hpLabelNumber.setText(""+playerHP);

		beginning_scene();
	}
	//screen after main menu and beginning of game
	public void beginning_scene(){
		position = "beginning_scene";

		textAreaPlus.setVisible(false);
		window.setBackground(Color.orange);
		

		mainTextArea.setText("In this game you will be taking orders from customers.\nFor each round, the time will get shorter and the game will fininsh when time is up!\nGood luck!\n");
		
		choice1.setText("CONTINUE");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	//start of customers for each level
	public void customer1(){
		position = "customer1";

		a = "00:00";
		timeLabelnum.setText(a);
		randomizer();

		choiceButtonPanel.setBackground(Color.white);
		choice2.setVisible(true);
		choice3.setVisible(true);
		choice4.setVisible(true);
		mainTextArea.setText("I would like a: " + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void customer2(){
		position = "customer2";

		timer.stop();
		a = "00:00";
		timeLabelnum.setText(a);
		randomizer();

		mainTextArea.setText("I would like a: " + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void customer3(){
		position = "customer3";

		timer.stop();
		a = "00:00";
		timeLabelnum.setText(a);
		randomizer();

		mainTextArea.setText("I would like a: " + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void customer4(){
		position = "customer4";

		timer.stop();
		a = "00:00";
		timeLabelnum.setText(a);
		randomizer();

		mainTextArea.setText("I would like a: " + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//end of customer setup
	//level setup
	public void levelone(){
		position = "levelone";
		
		a = "00:02";
		timeLabelnum.setText(a);
		b = 2;
		tick(a, b);
		mainTextArea.setText("What did the customer order?");		
		choice1.setText(""+ic1);
		choice2.setText(""+cc1);
		choice3.setText(""+cc2);
		choice4.setText(""+ic2);
	}
	public void leveltwo(){
		position = "leveltwo";

		a = "00:02";
		timeLabelnum.setText(a);
		b = 2;
		tick(a, b);
		mainTextArea.setText("What did the customer order?");		
		choice1.setText(""+ic1);
		choice2.setText(""+ic2);
		choice3.setText(""+cc2);
		choice4.setText(""+cc1);
	}
	public void levelthree(){
		position = "levelthree";

		a = "00:01";
		b = 1;
		tick(a, b);
		mainTextArea.setText("What did the customer order?");		
		choice1.setText(""+cc1);
		choice2.setText(""+ic1);
		choice3.setText(""+cc2);
		choice4.setText(""+ic2);
	}
	public void levelfour(){
		position = "levelfour";

		a = "00:01";
		b = 1;
		tick(a, b);
		mainTextArea.setText("What did the customer order?");		
		choice1.setText(""+ic1);
		choice2.setText(""+cc2);
		choice3.setText(""+cc1);
		choice4.setText(""+ic2);

	}
	//end of level setup
	//imperfect ending
	public void i_ending(){
		position = "i_ending";

		mainTextArea.setBackground(Color.white);
		timer.stop();
		a = "00:00";
		timeLabelnum.setText(a);
		
		mainTextArea.setText("Score: "+score);
		
		choiceButtonPanel.setBackground(Color.orange);
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	//perfect ending
	public void p_ending(){
		position = "p_ending";
		timer.stop();
		a = "00:00";
		timeLabelnum.setText(a);
		
		mainTextArea.setText("Perfect Score!\n You win!\n");
		
		choiceButtonPanel.setBackground(Color.orange);
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	//code for when time runs out
	public void timeup(){
		position = "timeup";

		mainTextArea.setBackground(Color.red);
		mainTextArea.setText("TIMES UP!!!");
		
		choiceButtonPanel.setBackground(null);
		choice1.setText("CONTINUE");
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	//beginning of code for timer
	Timer timer;	
	int second, minute;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");

	public void tick(String a, int b){
		timeLabelnum.setText(a);
		timeLabelnum.setFont(normalFont);
		
		second =b;
		minute =0;
		countdownTimer();
		timer.start();				
		if(second == 0){
			i_ending();
		}		
	}

	public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				timeLabelnum.setText(ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					timeLabelnum.setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
					timeup();
				}
			}
		});		
	}
	//end timer
	//allows for user clicking options to lead to next screen
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	
	//user imput for choices 1-4
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			//cases for different points in the game
			switch(position){
			case "beginning_scene":
				switch(yourChoice){
				case "c1": customer1();break;
				}
				break;
			case "customer1":
				switch(yourChoice){
				case "c1": levelone();break;
				}
				break;
			case "customer2":
				switch(yourChoice){
				case "c1": leveltwo();break;
				}
				break;
			case "customer3":
				switch(yourChoice){
				case "c1": levelthree();break;
				}
				break;
			case "customer4":
				switch(yourChoice){
				case "c1": levelfour();break;
				}
				break;
			case "levelone":
				switch(yourChoice){
					case "c1":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c2":
					as();
					customer2();
					break;
					case "c3":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c4":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
				}
				break;
			case "leveltwo":
				switch(yourChoice){
					case "c1":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c2":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c3":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c4":
					as();
					customer3();
					break;
				}
				
				break;
			case "levelthree":
				switch(yourChoice){
					case "c1":
					as();
					customer4();
					break;
					case "c2":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c3":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c4":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
				}
				break;
			case "levelfour":
				switch(yourChoice){
					case "c1":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c2":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					case "c3":
					as();
					p_ending();
					break;
					case "c4":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					break;
					}
					break;
				case "timeup":
					switch(yourChoice){
					case "c1":
					i_ending();
					break;
					}

			}
		}
	}
}
