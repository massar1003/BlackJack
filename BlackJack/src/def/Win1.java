package def;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.image.ImageProducer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Win1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtmatch;
	private JTextField txtans;
	private JTextField txtlose;
	private JTextField txtF_you;
	private JTextField txtF_my;
	private JTextField txtEnemy;
	private JTextField txtMyCard;
	private JTextField aware;
	private JTextArea log;
	private JTextField log_you;
	private JScrollPane scrollpane;
	static ImageIcon resizeIcon;
	static ImageIcon resizeIcon2;
	private kk1 engine;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		Win1 frame = new Win1();

	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(10, 10, 600, 500);	//ウィンドウの大きさ。setBounds(x座標, y座標, 幅, 高さ)
	    frame.setTitle("ブラックジャック");
	    frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Win1() {
		//BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		JPanel p = new JPanel();
	    p.setLayout(null);
	    
	    //背景の色
	    p.setBackground(Color.GREEN);

	    JButton b1 = new JButton("stan");
	    b1.setBounds(60, 200, 100, 40);

	    JButton b2 = new JButton("hit");
	    b2.setBounds(430, 200, 100, 40);

	    p.add(b1);
	    p.add(b2);

	    
	    getContentPane().add(p, BorderLayout.CENTER);
	    
	    txtmatch = new JTextField();
	    txtmatch.setText("match result");
	    txtmatch.setBounds(430, 349, 100, 20);
	    txtmatch.setHorizontalAlignment(JTextField.CENTER);		//中央ぞろえ
	    p.add(txtmatch);
	    txtmatch.setColumns(10);
	    
	    txtans = new JTextField();		//勝敗が表示される。
	    txtans.setBounds(430, 370, 100, 20);
	    txtans.setHorizontalAlignment(JTextField.CENTER);
	    p.add(txtans);
	    txtans.setColumns(10);
	    
	    
	    txtEnemy = new JTextField();
	    txtEnemy.setText("enemy");
	    txtEnemy.setBounds(250, 20, 100, 20);
	    txtEnemy.setHorizontalAlignment(JTextField.CENTER);
	    p.add(txtEnemy);
	    txtEnemy.setColumns(10);
	    
	    txtF_you = new JTextField();	//相手の最初の手札が表示される。
	    txtF_you.setBounds(250, 42, 100, 80);
	    txtF_you.setHorizontalAlignment(JTextField.CENTER);
	    p.add(txtF_you);
	    txtF_you.setColumns(10);
	    
	    
	    txtMyCard = new JTextField();
	    txtMyCard.setText("My Card");
	    txtMyCard.setBounds(250, 318, 100, 20);
	    txtMyCard.setHorizontalAlignment(JTextField.CENTER);
	    p.add(txtMyCard);
	    txtMyCard.setColumns(10);
	    
	    txtF_my = new JTextField();		//自分の手札の合計が表示される。
	    txtF_my.setBounds(250, 340, 100, 80);
	    txtF_my.setHorizontalAlignment(JTextField.CENTER);
	    p.add(txtF_my);
	    txtF_my.setColumns(10);
	    
	    aware = new JTextField();
	    aware.setBounds(405, 245, 150, 20);
	    aware.setHorizontalAlignment(JTextField.CENTER);
	    p.add(aware);
	    aware.setColumns(10);
	    
	    log = new JTextArea();		//ログを表示
	    log.setBounds(40, 270, 160, 180);
	    p.add(log);
	    log.setColumns(10);
	    
	    log_you = new JTextField();	//相手の最初の手札を表示
	    log_you.setBounds(390, 20, 190, 20);
	    log_you.setHorizontalAlignment(JTextField.CENTER);
	    p.add(log_you);
	    log_you.setColumns(10);
	    
	    //リスタートボタン
	    engine = new kk1(txtF_you, txtF_my, txtans, log, aware, log_you);
	    
	    JButton Temp1 = new JButton("Re.Start");
	    Temp1.setVisible(true);
	    Temp1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    		
	    		Win1 frame = new Win1();

	    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	    frame.setBounds(10, 10, 600, 500);
	    	    frame.setTitle("ブラックジャック");
	    	    frame.setVisible(true);
	    		
	    	}
	    });
	    Temp1.setBounds(26, 23, 86, 30);
	    p.add(Temp1);
	    b1.addActionListener(engine);
		b2.addActionListener(engine);
	    

	    //画像表示
	    Image im = null;
	    URL img1_url=this.getClass().getResource("/resource/card_back.png");
    	System.out.println("URL = " + img1_url);
	    try {
    		im=this.createImage((ImageProducer) img1_url.getContent());
   		}catch(Exception ex){
   			System.out.println("Resource Error!");
   			im=null;
   		}
	    
	    Image im2 = null;
	    URL img2_url=this.getClass().getResource("/resource/Black_Circle.png");
    	System.out.println("URL = " + img2_url);
	    try {
    		im2=this.createImage((ImageProducer) img2_url.getContent());
   		}catch(Exception ex){
   			System.out.println("Resource Error!");
   			im2=null;
   		}
    	
	    //BufferedImage bufferedImage = ImageIO.read(file);
		ImageIcon imageIcon = new ImageIcon(im);
		ImageIcon imageIcon2 = new ImageIcon(im2);
		JLabel img1 = new JLabel();
		JLabel img2 = new JLabel();
		JLabel img3 = new JLabel();
		JLabel img4 = new JLabel();
		JLabel img5 = new JLabel();
		JLabel img6 = new JLabel();
		
		//画像のサイズを変更(getScaledInstance(幅,高さ,スケーリングに使用するアルゴリズム)）
		Image resizeImg = imageIcon.getImage().getScaledInstance(50, 75, Image.SCALE_DEFAULT);
		MediaTracker tracker = new MediaTracker(this);
		// MediaTrackerで処理の終了を待ちます。
		tracker.addImage(resizeImg, 1);
		resizeIcon = new ImageIcon(resizeImg);
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			System.out.println("エラー");
		}
		
		Image resizeImg2 = imageIcon2.getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT);
		MediaTracker tracker2 = new MediaTracker(this);
		// MediaTrackerで処理の終了を待ちます。
		tracker2.addImage(resizeImg2, 1);
		resizeIcon2 = new ImageIcon(resizeImg2);
		try {
			tracker2.waitForAll();
		} catch (InterruptedException e) {
			System.out.println("エラー");
		}
		
		img1.setIcon(resizeIcon);
		img1.setBounds(400,50,100,100);	//setBounds(x座標, y座標, 幅, 高さ)
		p.add(img1);
		
		img2.setIcon(resizeIcon);
		img2.setBounds(420,50,100,100);
		p.add(img2);

		img3.setIcon(resizeIcon);
		img3.setBounds(440,50,100,100);
		p.add(img3);
		
		img4.setIcon(resizeIcon2);
		img4.setBounds(500,55,100,100);
		p.add(img4);
		
		img5.setIcon(resizeIcon2);
		img5.setBounds(520,55,100,100);
		p.add(img5);
		
		img6.setIcon(resizeIcon2);
		img6.setBounds(540,55,100,100);
		p.add(img6);
		
		p.setVisible(true);
	}
}
