package test;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

     //*********Found********
public class Java_31 extends JFrame implements ActionListener {
   private JTextField input1, input2, output;
   private int number1, number2;
   private double result;

   // 初始化
   public Java_31()
   {
     //*********Found********
      super( "示范一次" );//窗口名字

      Container c = getContentPane();//初始化容器
      c.setLayout( new GridLayout( 3, 2 ) );

      c.add( new JLabel( "输入分子",
                         SwingConstants.RIGHT ) );
      input1 = new JTextField( 10 );
      c.add( input1 );

      c.add(
         new JLabel( "输入分母和回车",
                     SwingConstants.RIGHT ) );
      input2 = new JTextField( 10 );
      c.add( input2 );
      input2.addActionListener( this );//this  在这里等于 actionPerformed方法

      c.add( new JLabel( "计算结果", SwingConstants.RIGHT ) );
      output = new JTextField();
      c.add( output );

      setSize( 425, 100 );
      show();
   }

   //处理 GUI 事件
   public void actionPerformed( ActionEvent e )
   {
      DecimalFormat precision3 = new DecimalFormat( "0.000" );

      output.setText( "哈哈哈哈" ); // 空的JTextField输出

     //*********Found********
      try {         
         number1 = Integer.parseInt( input1.getText() );
         number2 = Integer.parseInt( input2.getText() );

         result = quotient( number1, number2 );
     //*********Found********
         output.setText(precision3.format(result));
      }
      catch ( NumberFormatException nfe ) {
         JOptionPane.showMessageDialog( this,
            "你必须输入两个整数",
            "非法数字格式",
            JOptionPane.ERROR_MESSAGE );
      }
      catch ( Exception dbze ) {
     //*********Found********
         JOptionPane.showMessageDialog( this, 
            "除法异常",
            "除数为零",
            JOptionPane.ERROR_MESSAGE );
      }
   }

   // 定义求商的方法，如遇除数为零时，能抛出异常。
     public double quotient( int numerator, int denominator )
      throws Exception
   {
      if ( denominator == 0 )
         throw new Exception();

      return ( double ) numerator / denominator;
   }

   public static void main( String args[] )
   {
      Java_31 app = new Java_31();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               e.getWindow().dispose();
               System.exit( 0 );
            }
         }
      );
   }
}
/* JOptionPane类的常用静态方法如下：
   showInputDialog()
   showConfirmDialog()
   showMessageDialog()
   showOptionDialog()
*/