

import java.awt.Color;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class solvematrix {
int r,c,x1,x2,y1,y2,block=0;
public static int p=0;
	solvematrix (JButton b[][],int n,int m,int dp[][],char palace[][],int bl) throws InterruptedException
	{ 
	    r=n;
	    c=m;
	    int k=0;
	    assigndp(dp);
	    Thread t;
	    for(int i=0;i<r;i++)
	    {
	        for(int j=0;j<c;j++)
	        {
	            if(dp[i][j]==0&&palace[i][j]=='.'){
	            	
	            block++;
	            x1=x2=i;y1=y2=j;
	            find_boundary(i,j,b,dp,palace);
	            p+=Math.min(x2-x1+1, y2-y1+1);
	            solvepart sp=new solvepart(x1,x2,y1,y2,block,b,1);
	            t=new Thread(sp);
	            t.start();
	            }
	        }
	    }
	}

void assigndp(int dp[][])
{
    for(int i=0;i<r;i++)
    { for(int j=0;j<c;j++)
        {
        	dp[i][j]=0;
        	
        }
    }
}

boolean is_safe_index(int x,int y)
{
    return (x>=0&&x<r&&y>=0&&y<c);
}

void find_boundary(int x,int y,JButton b[][],int dp[][],char palace[][])
{
    if(is_safe_index(x,y)&&palace[x][y]=='.'&&dp[x][y]==0)
    {
    	
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
