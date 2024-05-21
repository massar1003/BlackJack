package def;

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.util.Random;
import java.util.Arrays;

public class kk1 implements ActionListener {

	private JTextField txtF_you;
	private JTextField txtF_my;
	private JTextField txtans;
	private JTextField aware;
	private JTextField log_you;
	private JTextArea log;
	private JLabel img3;
	
	private int n=0;
	private int m=0;
	private int Mysum=0;
	private int Yousum = 0;
	private int card[] = new int[40];
	private int drawcard_my = 0;
	private int drawcm[] = new int[2];
	private int drawcard_you = 0;
	private int drawcy[] = new int[2];
	private int drawnum = 0;
	
	public kk1(JTextField txtF_you,JTextField txtF_my, JTextField txtans, JTextArea log, JTextField aware, JTextField log_you) {
		this.txtF_my = txtF_my;
		this.txtans = txtans;
		this.txtF_you = txtF_you;
		this.log = log;
		this.aware = aware;
		this.log_you = log_you;
		
		int j=0;
		for (int i = 0; i < 10; i++) {
			card[ i + j ] = i+1;
			card[ i + (j+1) ] = i+1;
			card[ i + (j+2) ] = i+1;
			card[ i + (j+3) ] = i+1;
			
			j =j+3;		
		}
		
		n=0;
		m=0;
		
		
		while( n<1 ) {
			Random rand = new Random();
			drawnum=rand.nextInt(40);
			drawcard_my = card[drawnum];
			
			if( drawcard_my != 0 ) {
				Mysum+=drawcard_my;
				
				card[drawnum] = 0;
				
				System.out.println(Arrays.toString(card));
				
				System.out.println(n + " my : " + drawcard_my);
				
				
				File file = new File("src/ee");
				File[] fileList = file.listFiles();
				
				System.out.println(fileList);
				
				drawcm[n] = drawcard_my;
				
				n++;
			}
		}
		
		String My = ""+Mysum;
		txtF_my.setText(My);
		
		log.setText("   あなたは" + drawcm[0] + "を引きました。\n");		//最初に引いたカードの表示
		
		while( m<2 ) {
			Random rand = new Random();
			drawnum=rand.nextInt(40);
			drawcard_you = card[drawnum];
			
			if( drawcard_you != 0 ) {
				Yousum+=drawcard_you;
				
				card[drawnum] = 0;
				
				System.out.println(Arrays.toString(card));
				
				System.out.println(m + " you : " + drawcard_you);
				
				drawcy[m] = drawcard_you; 
				
				m++;
			}
		}
		String You = ""+Yousum;
		txtF_you.setText(You);
		
		log_you.setText("相手は最初" + drawcy[0] + "と" + drawcy[1] + "を引きました。");		//相手が最初に引いたカードを表示
		
	}
	

	public void actionPerformed(ActionEvent e) {
//		txtF_my.setText(e.getActionCommand());
		
		String key = e.getActionCommand();	//押されたキーを取得
		
		String ans = null;
		
		if (key=="hit") {
			
			Random rand = new Random();
			drawnum=rand.nextInt(40);
			drawcard_my = card[drawnum];
			
			if( drawcard_my != 0 ) {
				Mysum+=drawcard_my;
				
				card[drawnum] = 0;
				
				System.out.println(Arrays.toString(card));		//コンソールに表示
				System.out.println(n + " my : " + drawcard_my);

				ans = ""+Mysum;
				txtF_my.setText(ans);
				
				log.append("   あなたは" + drawcard_my + "を引きました。\n");	//引いたカードのログを表示
				aware.setText("");
			} else {
				aware.setText("もう一度押してください。");
			}
			
		}
		
		if(key=="stan") {
			
			while( Yousum<17 ){
				Random rand = new Random();
				drawnum=rand.nextInt(40);
				drawcard_you = card[drawnum];
				
				if( drawcard_you != 0 ) {
					Yousum+=drawcard_you;
					
					card[drawnum] = 0;
					
					System.out.println(Arrays.toString(card));
					
					System.out.println(m + " you : " + drawcard_you);
					
					m++;
				}
			}
			String You = ""+Yousum;
			txtF_you.setText(You);
			
			//ここに相手の手札の枚数(m枚)だけカードを表示させるような処理を追加したい
//			int x = 440;
//			while(m>0) {
//				img3.setIcon(Win1.resizeIcon);
//				img3.setBounds(x,30,100,100);
//				x = x + 20;
//				m--;
//			}
			
			int com = 21-Yousum;
			int player = 21-Mysum;
			
			
			if((player<0 && com<0) || (player-com==0)) {
	               // return 0;//引き分け
	                txtans.setText("draw");
	            
	        }else if((player<com && player>=0 && com>0)||(player>com && player>=0 && com<0)){
	               // return 1;
	                txtans.setText("win");
	                txtans.setForeground(Color.RED);

	        }else if((player>com && player>0 && com>=0)||(com>player && com>=0 && player<0)) {
	               // return -1;
	                txtans.setText("lose");
	                txtans.setForeground(Color.BLUE);
	        }else {
	                System.out.println("エラーが発生しました（Judge）。０を返します");
	               // return 0;
	                txtans.setText("draw");

	        }				
		}	
	}
}
