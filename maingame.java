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

public class maingame {
	JFrame window;
	//creates window
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, menuPanel, entirePanel;
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
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	ImageIcon logo = new ImageIcon("character_themuppets_kermit_b77a431b.jpeg");
	//Icon for game


	public static void main(String[] args) {

		new maingame();
	}
	
	public maingame(){
		
		window = new JFrame();
		window.setSize(800, 600);
		//size of window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.yellow);
		//background color for title and game
		window.setLayout(null);
		window.setIconImage(logo.getImage());
		//adds icon for game
		//add cat icon
		con = window.getContentPane();

		entirePanel = new JPanel();
		entirePanel.setBounds(800,600,800,600);
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.orange);
		//color for title panel
		titleNameLabel = new JLabel("Cat Order Game");
		titleNameLabel.setForeground(Color.gray);
        //color for title
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.pink);
		//color for clock-in panel
		
		startButton = new JButton("CLOCK IN");
		startButton.setBackground(Color.white);
        //background color of start button
		startButton.setForeground(Color.gray);
        //color of text for start button
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
		//end of title screen
	}
	
	public void createGameScreen(){
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.blue);
        //
		con.add(mainTextPanel);		
		mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
        //
		mainTextArea.setForeground(Color.white);
        //
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true); 
		mainTextArea.setEditable(false); 	
		
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
        //
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		//
		choice1.setForeground(Color.white);
		//
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler); 
		choice1.setActionCommand("c1"); 
		choiceButtonPanel.add(choice1);
		//end of option 1

		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		//end of option 2

		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		//end of option 3

		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		//end of option 4
		
//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!
		menuPanel = new JPanel();
		menuPanel.setFont(normalFont);
		menuPanel.setBounds(50,700,100,50);
		menuPanel.setBackground(Color.black);
		menuPanel.setLayout(new GridLayout(7,2));
		con.add(menuPanel);
		//drinks
		coffee = new JLabel("Plain Coffee");
		coffee.setFont(normalFont);
		coffee.setForeground(Color.white);
		menuPanel.add(coffee);
		latte = new JLabel("Latte");
		latte.setFont(normalFont);
		latte.setForeground(Color.white);
		menuPanel.add(latte);
		espresso = new JLabel("Espresso");
		espresso.setFont(normalFont);
		espresso.setForeground(Color.white);
		menuPanel.add(espresso);
		//treats
		cake = new JLabel("Cake Slice");
		cake.setFont(normalFont);
		cake.setForeground(Color.white);
		menuPanel.add(cake);
		muffin = new JLabel("Muffin");
		muffin.setFont(normalFont);
		muffin.setForeground(Color.white);
		menuPanel.add(muffin);
		cookie = new JLabel("Cookie");
		cookie.setFont(normalFont);
		cookie.setForeground(Color.white);
		menuPanel.add(cookie);

		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		//color for player panel
		playerPanel.setLayout(new GridLayout(1, 4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		timeLabel = new JLabel("TIMER:");
		timeLabel.setFont(normalFont);
		timeLabel.setForeground(Color.white);
		playerPanel.add(timeLabel);
		timeLabelnum = new JLabel();
		timeLabelnum.setFont(normalFont);
		timeLabelnum.setForeground(Color.white);
		playerPanel.add(timeLabelnum);

		playerSetup();

	}
	public void playerSetup(){
		playerHP = 50;
		hpLabelNumber.setText(""+playerHP);

		beginning_scene();
	}
	public void beginning_scene(){
		position = "beginning_scene";
		mainTextArea.setText("In this game you will be taking orders from customers.\n For each round, the time will get shorter and the game will fininsh when time is up!\n Good luck!\n");
		choice1.setText("CONTINUE");
		choice2.setText("RETURN");
		choice3.setText("");
		choice4.setText("");
	}

	//start of choices
	//Scanner lol = new Scanner(System.in);
	int cc1, cc2;
	//int [] ans = new int[1];
	int ic1, ic2;
	int p1, p2;
	int rndmElem_one, rndmElem_two, rndmElem_three, rndmElem_four;
	int score;

	public void randomizer(){
      // Creating arraylist 
      ArrayList<Integer> araylist = new ArrayList<Integer>();
      araylist.add(1);
      araylist.add(2);
      araylist.add(3);
      araylist.add(4);
      araylist.add(5);
      araylist.add(6);
      Random rndm = new Random();
      //int rndmIndx;
        
	  int rndmIndx1 = rndm.nextInt(araylist.size());
      int rndmIndx2 = rndm.nextInt(araylist.size());
      int rndmIndx3 = rndm.nextInt(araylist.size());
      int rndmIndx4 = rndm.nextInt(araylist.size());
        
      rndmElem_one = araylist.get(rndmIndx1);
      rndmElem_two = araylist.get(rndmIndx2);
	  if(rndmElem_two == rndmElem_one){
		rndmElem_two = araylist.get(rndmIndx2);
	  }
	  else if(rndmElem_two != rndmElem_one){
      	rndmElem_three = araylist.get(rndmIndx3);
	  if(rndmElem_three == rndmElem_two || rndmElem_three == rndmElem_one){
		rndmElem_three = araylist.get(rndmIndx3);
	  }
	  else if(rndmElem_three != rndmElem_two && rndmElem_three != rndmElem_one){
		rndmElem_four = araylist.get(rndmIndx4);
		if(rndmElem_four == rndmElem_three || rndmElem_four == rndmElem_two || rndmElem_four == rndmElem_one){
			rndmElem_four = araylist.get(rndmIndx4);
		}
	  else if(rndmElem_four != rndmElem_three && rndmElem_four != rndmElem_two && rndmElem_four != rndmElem_one){
			
	  }
		
	  }
	  }
        
	 //int cc1, cc2;
      cc1 = rndmElem_two;
      cc2 = rndmElem_three;
	  ic1 = rndmElem_one;
	  ic2 = rndmElem_four;
	}
	public void subh(){
		mainTextArea.setText("WRONG");
		playerHP = playerHP- 10;
		//return hpLabelNumber;
	}
	public void as(){
		mainTextArea.setText("CORRECT");
		score = score + 25;
	}
	public void customer1(){
		position = "customer1";
		randomizer();
		mainTextArea.setText("I would like:" + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("RETURN");
		choice3.setText("");
		choice4.setText("");
	}
	public void customer2(){
		position = "customer2";
		randomizer();
		mainTextArea.setText("I would like:" + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("RETURN");
		choice3.setText("");
		choice4.setText("");
	}
	public void customer3(){
		position = "customer3";
		randomizer();
		mainTextArea.setText("I would like:" + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("RETURN");
		choice3.setText("");
		choice4.setText("");
	}
	public void customer4(){
		position = "customer4";
		randomizer();
		mainTextArea.setText("I would like:" + cc1);
		choice1.setText("CONTINUE");
		choice2.setText("RETURN");
		choice3.setText("");
		choice4.setText("");
	}
	public void levelone(){
		position = "levelone";
		
		a = "00:16";
		b = 16;
		tick();
		mainTextArea.setText("What did the customer order");		
		choice1.setText(""+ic1);
		choice2.setText(""+cc1);
		choice3.setText(""+cc2);
		choice4.setText(""+ic2);
	}
	public void leveltwo(){
		position = "leveltwo";

		a = "00:12";
		b = 12;
		tick();
		mainTextArea.setText("What did the customer order");		
		choice1.setText(""+ic1);
		choice2.setText(""+ic1);
		choice3.setText(""+cc2);
		choice4.setText(""+cc1);
	}
	public void levelthree(){
		position = "levelthree";
		a = "00:08";
		b = 8;
		tick();
		mainTextArea.setText("What did the customer order");		
		choice1.setText(""+cc1);
		choice2.setText(""+ic1);
		choice3.setText(""+cc2);
		choice4.setText(""+ic2);
	}
	public void levelfour(){
		position = "levelfour";

		a = "00:04";
		b = 4;
		tick();
		mainTextArea.setText("What did the customer order");		
		choice1.setText(""+ic1);
		choice2.setText(""+cc2);
		choice3.setText(""+cc1);
		choice4.setText(""+ic2);

	}
	public void i_ending(){
		position = "i_ending";
		
		mainTextArea.setText("Score: "+score);
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	public void p_ending(){
		position = "p_ending";
		
		mainTextArea.setText("Perfect Score!\n You win!\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);
	}
	//timer start 
	//JLabel counterLabel;
	//Font font1 = new Font("Comic Sans MS", Font.PLAIN, 30);	
	Timer timer;	
	int second, minute;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");

	public void tick(){
		
		//window = new JFrame();
		//window.setSize(800,600);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setLayout(null);
		
		//counterLabel = new JLabel("");
		//counterLabel.setBounds(0, 0, 100, 100);
		//counterLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabelnum.setFont(normalFont);
		
		window.add(timeLabelnum);
		window.setVisible(true);
		
		// Countdown Timer
		timeLabelnum.setText(a);
		second =b;
		minute =0;
		countdownTimer();
		timer.start();						
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
				}
			}
		});		
	}
	//end timer
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	

	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
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
					else{
					levelone();
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
					else{
					levelone();
					}
					break;
					case "c4":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					levelone();
					}
					break;
				}
				/*if(second == 0){
					//add color
					entirePanel.setBackground(Color.red);
					mainTextArea.setText("TIME IS UP!!!");
					i_ending();
				}*/
				break;
			case "leveltwo":
				switch(yourChoice){
					case "c1":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					leveltwo();
					}
					break;
					case "c2":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					leveltwo();
					}
					break;
					case "c3":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					leveltwo();
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
					else{
					levelthree();
					}
					break;
					case "c3":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					levelthree();
					}
					break;
					case "c4":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					levelthree();
					}
				}
				break;
			case "levelfour":
				switch(yourChoice){
					case "c1":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					levelfour();
					}
					break;
					case "c2":
					subh();
					if(playerHP == 0){
						i_ending();
					}
					else{
					levelfour();
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
					else{
					levelfour();
					}
				}
				break;
			}
		}
	}
}
