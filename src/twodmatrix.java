
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class twodmatrix extends JFrame implements ActionListener{

	Container c;
	JLabel l1,l2,l3;
	static int timer;
	Icon img,img1;
	JButton back;
	String st;
	JButton b[][],b1,b2,b3,b4;
	JButton del,sav;
	int dp[][];
	char palace[][];
	int bs;
	ResultSet rs;
	int sc=0;
	int x1,x2,y1,y2;
	int n,m,b_size=70;
	boolean run_status=true;
	int knight_moves[][];
	twodmatrix(int nt,int mt)
	{

		c=getContentPane();
		c.setBackground(new Color(244,164,96));//(205,133,63));//(139,69,19));//(154,205,50));//(238,232,170));//(255,228,181));
		sc=0;
		n=nt;
		m=mt;
		if(Math.max(n,m)>7)
			b_size=60;
		if(Math.max(n, m)>12)
			b_size=30;
		
		 m++;
			int x=(1405/2-b_size*m/2);
			n++;
			int y=(780/2-b_size*n/2);//+25);
			n--;
			m--;
		// c.add(l1);
		 b=new JButton[n][m];
		 dp=new int[n][m];	
		 palace= new char[n][m];
		for(int i=0;i<n;i++)
		{ for(int j=0;j<m;j++)
			{
				b[i][j]=new JButton("");
						b[i][j].setBounds(x,y,b_size-10,b_size-10);
						x=x+b_size;
						b[i][j].addActionListener(this);
						c.add(b[i][j]);
			}
		
			y=y+b_size;
			x=(1405/2-b_size*(m+1)/2);
		
		}
		knight_moves =new int[8][8];
		knight_moves[0][0]=-2;
		knight_moves[0][1]=-1;
		knight_moves[1][0]=-2;
		knight_moves[1][1]=1;
		knight_moves[2][0]=-1;
		knight_moves[2][1]=-2;
		knight_moves[3][0]=-1;
		knight_moves[3][1]=2;
		knight_moves[4][0]=2;
		knight_moves[4][1]=-1;
		knight_moves[5][0]=2;
		knight_moves[5][1]=1;
		knight_moves[6][0]=1;
		knight_moves[6][1]=-2;
		knight_moves[7][0]=1;
		knight_moves[7][1]=2;
		
		
		new assignmatrix(b,n,m,dp,palace);
		
		assigndp();
		setTitle("Lets Play Super-Queen Game");
		setSize(1410,810);//768);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 if(Math.max(n,m)<8)
		 {
			 img1=new ImageIcon("D:\\queen.png");
		      img= new ImageIcon("D:\\wqueen.png");
		 }
		 else if(Math.max(n, m)>12)
		 {
			
			 img1=new ImageIcon("D:\\gaurd_s.png");
		     img= new ImageIcon("D:\\blood.png");
		 }
		 else{
			 img1=new ImageIcon("D:\\queen1.png");
		      img= new ImageIcon("D:\\wqueen1.png");
		    }
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		b4=new JButton();
		m++;
		x=(1405/2-b_size*m/2);
		n++;
		y=(780/2-b_size*n/2);//+25);
		n--;
		m--;
		b1.setBounds(x-10,y-10,b_size*m+10,5);
		b1.setBackground(new Color(205,92,92));
		b2.setBounds(x+b_size*m-5,y-10,5,b_size*n+10);
		b2.setBackground(new Color(205,92,92));
		b3.setBounds(x-10,y+b_size*n-5,b_size*m+10,5);
		b3.setBackground(new Color(205,92,92));
		b4.setBounds(x-10,y-10,5,b_size*n+10);
		b4.setBackground(new Color(205,92,92));

		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		ct=0;

		setVisible(true);
		
	}


void assigndp()
{
    for(int i=0;i<n;i++)
    { for(int j=0;j<m;j++)
        {
        	dp[i][j]=0;
        	if((b[i][j].getIcon()==img1||b[i][j].getIcon()==null))
        	{
        		palace[i][j]='.';
        	}
        	else 
        		palace[i][j]='#';
        }
    }
}
boolean is_safe_index(int x,int y)
{
    return (x>=0&&x<n&&y>=0&&y<m);
}


void find_boundary(int x,int y)
{
	 System.out.println("X1=> "+x);
	 System.out.println("Y1=> "+y);
	 

    if(is_safe_index(x,y)&&palace[x][y]=='.'&&dp[x][y]==0)
    {
	
    	System.out.println("palace[][]"+palace[x][y]);
        dp[x][y]=1;
    x1=Math.min(x1,x);x2=Math.max(x2,x);
    y1=Math.min(y1,y);y2=Math.max(y2,y);
    find_boundary(x-1,y);
    find_boundary(x+1,y);
    find_boundary(x,y-1);
    find_boundary(x,y+1);
    }
}

	
	public static void main(String args[]){
		//twodmatrix d=new twodmatrix(10,11);
		twodmatrix d1=new twodmatrix(23,40);
		
	}

	int ct;
	@Override
	public void actionPerformed(ActionEvent e) {
		
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(e.getSource()==b[i][j]){
						if(run_status&&(b[i][j].getIcon()==img1||b[i][j].getIcon()==null))
					{
						if(b[i][j].getIcon()==img1)
							{ sc--; b[i][j].setIcon(null); b[i][j].setBackground(new JButton().getBackground());}
						else
						{
							if(canPlaceQueen(i,j))
								{ b[i][j].setIcon(img1);  sc++;}
							else
							{
								b[i][j].setBackground(Color.white);
								b[i][j].setIcon(img);
								Rectangle r=b[i][j].getBounds();
							    b[i][j].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);
								JOptionPane.showMessageDialog(null,"Out of "+assignmatrix.p + " ,you correctly placed "+sc+" gaurds.\nYour Score is => "+(float)sc*10/assignmatrix.p);
								run_status=false;
								
							}
							if(sc==assignmatrix.p)
							{
								
								JOptionPane.showMessageDialog(null,"Well Done !!!");
								run_status=false;

							}
					}
				} else if(!(run_status||b[i][j].getIcon()==img1||b[i][j].getIcon()==null||b[i][j].getIcon()==img))
							try {
								 m++;
									int x=(1405/2-b_size*m/2);
									n++;
									int y=(780/2-b_size*n/2);//+25);
									n--;
									m--;
								
								for(int ir=0;ir<n;ir++)
								{ for(int jc=0;jc<m;jc++)
									{
										
												b[ir][jc].setBounds(x,y,b_size-10,b_size-10);
												x=x+b_size;
												
									}
								
									y=y+b_size;
									x=(1405/2-b_size*(m+1)/2);
								
								}
								new solvematrix(b,n,m,dp,palace,assignmatrix.p);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
			}
		}
	}
	

boolean is_safe_index_pos(int x,int y)
{
    return (x>=x1&&x<=x2&&y>=y1&&y<=y2);
}

	
	public boolean canPlaceQueen(int row, int col) {
		 int i=row, j=col;
		 x1=i;
		 x2=i;
		 y1=j;
		 y2=j;
		 assigndp();
		 find_boundary(i,j);
		 System.out.println("X=> \n");
		 System.out.println(x1);
         System.out.println(x2);
		 System.out.println("Y=> \n");
         System.out.println(y1);
         System.out.println(y2);
         
         for (j = y1; j <=y2; j++)
		        if (b[row][j].getIcon()==img1)
		            { b[row][j].setIcon(img); b[row][j].setBackground(Color.yellow); 
					Rectangle r=b[i][j].getBounds();
				    b[row][j].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);return false; }
		            
		    for (i = x1; i <= x2; i++)
		        if (b[i][col].getIcon()==img1)
		            { b[i][col].setIcon(img); b[i][col].setBackground(Color.yellow);  
					Rectangle r=b[i][col].getBounds();
				    b[i][col].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);return false; }
		            
		    for (i=row, j=col; i>=x1 && j>=y1; i--, j--)
		        if (b[i][j].getIcon()==img1)
	            { b[i][j].setIcon(img); b[i][j].setBackground(Color.yellow); 
				Rectangle r=b[i][j].getBounds();
			    b[i][j].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);return false; }

		    for (i=row, j=col; i<=x2 && j<=y2; i++, j++)
		        if (b[i][j].getIcon()==img1)
	            { b[i][j].setIcon(img); b[i][j].setBackground(Color.yellow); 
				Rectangle r=b[i][j].getBounds();
			    b[i][j].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);return false; }
		 
		    for (i=row, j=col; j>=y1 && i<=x2; i++, j--)
		        if (b[i][j].getIcon()==img1)
	            { b[i][j].setIcon(img); b[i][j].setBackground(Color.yellow); 
				Rectangle r=b[i][j].getBounds();
			    b[i][j].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);return false; }

		    for (i=row, j=col; j<=y2 && i>=x1; i--, j++)
		        if (b[i][j].getIcon()==img1)
	            { b[i][j].setIcon(img); b[i][j].setBackground(Color.yellow); 
				Rectangle r=b[i][j].getBounds();
			    b[i][j].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);return false; }
		    
		    for(int k=0;k<8;k++)
		    {
		    	i=row+knight_moves[k][0];
		    	j=col+knight_moves[k][1];
		    	if(is_safe_index_pos(i,j)&&b[i][j].getIcon()==img1)
		    	{
		    		b[i][j].setIcon(img); b[i][j].setBackground(Color.yellow); 
					Rectangle r=b[i][j].getBounds();
				    b[i][j].setBounds(r.x-4, r.y-4, r.width+8, r.height+8);return false;
		    	}
		    }
		    return true;

    }

}
	
