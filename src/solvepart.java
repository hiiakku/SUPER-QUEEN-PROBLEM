

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class solvepart implements Runnable {

int r1,c1,r2,c2,bl,m=0,r,c;
JButton bt[][];
boolean h[],v[];
int dp[][],ans[][],ans_count=0;
int knight_moves[][];
int bit;

void assigndp()
{
    for(int i=0;i<r;i++)
    { for(int j=0;j<c;j++)
        {
        	dp[i][j]=0;
        	v[j]=false;
        }
    h[i]=false;
    }
}

	solvepart (int x1,int x2,int y1,int y2,int blck,JButton b[][],int bit) throws InterruptedException
	{ 
		bt=b;
		bl=blck;
	    r1=x1;
	    r2=x2;
	    c1=y1;
	    c2=y2;
	    
	    this.bit=bit;
	}


Color new_Color(int b)
{
	Color cl;
	switch (b)
	{
	case 0:
		cl=new Color(205,192,92);
		break;
	case 1:
		cl=new Color(46,139,87);
		break;
	case 2:
		cl=new Color(200,192,132);
		break;
	case 3:
		cl=new Color(135,206,250);
		break;
	case 4:
		cl=new Color(180,180,180);
		break;
	case 5:
		cl=new Color(155,229,180);
		break;
	case 6:
		cl=new Color(186,85,211);
		break;
	case 7:
		cl=new Color(225,158,179);
		break;
	default:
		cl=new_Color(b%8);
	}
	return cl;
	
}

boolean is_safe_index(int x,int y)
{
    return (x>=0&&x<r&&y>=0&&y<c);
}

boolean is_safe(int row,int col)
{
	if(v[col]) return false;
	int i,j;
	

	for (i=row, j=col; i>=0 && j>=0; i--, j--)
        if (dp[i][j]==1)
        { return false; }
 
   
    for (i=row, j=col; j<c && i>=0; i--, j++)
        if (dp[i][j]==1)
        {return false; }
    
    for(int k=0;k<4;k++)
    {
    	i=row+knight_moves[k][0];
    	j=col+knight_moves[k][1];
    	if(is_safe_index(i,j)&&dp[i][j]==1)
    	{
    		return false;
    	}
    }
	return true;
}


void update_sol(int count)
{
	for(int i=0;i<r;i++)
	{
		for(int j=0;j<c;j++)
			ans[i][j]=dp[i][j];
	}
	ans_count=count;
}

boolean solveit(int x,int cnt)
{
	if(cnt==m) 
		{ update_sol(cnt); return true; }
	
	if(x>=r)
	{
		if(cnt>ans_count) update_sol(cnt);
		return false;
	}
	for(int j=x;j<r;j++)
	{
	for(int i=0;i<c;i++)
	{
		if(is_safe(j,i))
		{
			
			v[i]=true;
			dp[j][i]=1;
			
			boolean rt=solveit(j+1,cnt+1);
			if(rt) return rt;
			
			dp[j][i]=0;
			
			v[i]=false;
			
		}
	}
	}
	return false;
}

@Override
public void run()
{
	
	
	r=r2-r1+1;
	c=c2-c1+1;
	m=Math.min(r, c);
	
	h=new boolean[r];
	v=new boolean[c];
	dp=new int[r][c];
	ans=new int[r][c];
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
	assigndp();
	solveit(0,0);
	ImageIcon img1=new ImageIcon("D:\\gaurd_s.png");
	System.out.println("inside");
   if(bit>0)
   {
	for(int i=r1;i<=r2;i++)
    {
        for(int j=c1;j<=c2;j++)
            	{
        			bt[i][j].setIcon(null);
        			bt[i][j].setBackground(new_Color(bl));   	
        			if(ans[i-r1][j-c1]==1)
        				bt[i][j].setIcon(img1);
        			System.out.print(ans[i-r1][j-c1]+" ");
            	}
        System.out.println();
    }
   }
    assignmatrix.p+=ans_count;

}
}
