

import java.awt.Color;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class assignmatrix {

int r,c,x1,x2,y1,y2,block=0;
public static int p=0;

	assignmatrix(JButton b[][],int n,int m,int dp[][],char palace[][])
	{ 
	    r=n;
	    c=m;
	    palace=new char[n][m];
	    dp=new int[n][m];		
	    assigndp(dp);
	    String data = "";
	    Scanner sc=new Scanner(System.in);  
	    int count = 0;
	    Thread t;
	    for (int i = 0; i < n; i++) {
	        if (sc.hasNext()) {
	            data = sc.next();
	            count = 0;
	        } else {
	            break;
	        }
	        for (int j = 0; j < m; j++)
	        palace[i][j] = data.charAt(count++);
	    }
	    for(int i=0;i<r;i++)
	    {
	        for(int j=0;j<c;j++)
	        {
	            if(dp[i][j]==0&&palace[i][j]=='.'){
	            block++;
	            x1=x2=i;y1=y2=j;
	            find_boundary(i,j,b,dp,palace);
	            
	            

	            solvepart sp;
				try {
					sp = new solvepart(x1,x2,y1,y2,block,b,0);
					 t=new Thread(sp);
			            t.start();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           
	           
	            
	            }
	            if(palace[i][j]=='#')
	        		b[i][j].setIcon(new ImageIcon("D:\\brick.jpg"));

	        }
	    }

	}

void assigndp(int dp[][])
{
    for(int i=0;i<r;i++)
        for(int j=0;j<c;j++)
            dp[i][j]=0;
}


boolean is_safe_index(int x,int y)
{
    return (x>=0&&x<r&&y>=0&&y<c);
}


void find_boundary(int x,int y,JButton b[][],int dp[][],char palace[][])
{
    if(is_safe_index(x,y)&&palace[x][y]=='.'&&dp[x][y]==0)
    {
		b[x][y].setBackground(new Color(238,232,170));

        dp[x][y]=block;
    x1=Math.min(x1,x);x2=Math.max(x2,x);
    y1=Math.min(y1,y);y2=Math.max(y2,y);
    find_boundary(x-1,y,b,dp,palace);
    find_boundary(x+1,y,b,dp,palace);
    find_boundary(x,y-1,b,dp,palace);
    find_boundary(x,y+1,b,dp,palace);
    }
}

}
