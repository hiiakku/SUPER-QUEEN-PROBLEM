

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener
{
	
	JLabel a1,a2;
	JTextField t1,t2;
	JButton b1;
		 login()
	 {
			 super("welcome in java by sandeep sir login page");
			 setSize(600,600);
			 setVisible(true);
			 setLayout(null);
			 a1=new JLabel("name");
			 a1.setBounds(100,100,50,40);
			 add(a1);
			 	
			 t1=new JTextField();
			 t1.setBounds(200,100,50,40);
			 add(t1);
			 
			 a2=new JLabel("pass");
			 a2.setBounds(100,200,50,40);
			 add(a2);
			 	
			 t2=new JTextField();
			 t2.setBounds(200,200,50,40);
			 add(t2);
			b1=new JButton("login"); 
			b1.setBounds(200,300,50,40);
			 add(b1);
			 b1.addActionListener(this);
			 
			 
			 	 
		 
	 }
	public static void main(String s[])
	{
		new login();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String a=t1.getText();
//		int a1=Integer.parseInt(a);
		String b=t2.getText();
		
		try
		{
			/*
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql:" +
		"//localhost:3306/my1","root","root");
		*/
			Connection cn=DB.mycon();
		
//Statement st=cn.createStatement();
//ResultSet rs=st.executeQuery("select * from emp where name='"+a+"'   and upass='"+b+"'");
PreparedStatement ps=cn.prepareStatement("select * from emp where name=? and upass=?");

ps.setString(1,a);
ps.setString(2,b);



ResultSet rs=ps.executeQuery();


boolean ss=rs.next();

if(ss)
{
	System.out.println("ok "+ss);
	//System.out.println("ok "+rs.getString(2));

	
}
else
{
	System.out.println("invalid "+ss);
}

		
		
		} 
		catch (Exception e1) 
		{


			e1.printStackTrace();
		}
	}
}



