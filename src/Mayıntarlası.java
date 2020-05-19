import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


   class AnaSayfa implements ActionListener,MouseListener {
    
       private JFrame ekran = null;
       private JPanel üstkısım = new JPanel();
       private JButton yb_emoji = new JButton("");
       private JPanel cmp = new JPanel();
       
       
       
       ImageIcon yb_emojiImageIcon = null;
       ImageIcon tImageIcon = null;
       ImageIcon mayinImageIcon = null;
       ImageIcon zararImageIcon=null;
       ImageIcon üs_emojiImageIcon=null;
       ImageIcon beşImageIcon = null;
       ImageIcon dörtImageIcon=null;
       ImageIcon üçImageIcon=null;
       ImageIcon ikiImageIcon=null;
       ImageIcon birImageIcon=null;
       
       
       
       
       public AnaSayfa(){
           ekran= new JFrame("Mayın Tarlası");
           ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           ekran.setVisible(true);
           ekran.setResizable(true);
           ekran.setJMenuBar(Menu());
           mayıntarlasıyükleme();
           
           cmp.setLayout(new BorderLayout());
           yb_emoji.setPreferredSize(new Dimension(45,35));
           yb_emoji.setIcon(yb_emojiImageIcon);
           üstkısım.add(yb_emoji);
           cmp.add(üstkısım,BorderLayout.NORTH);
           yb_emoji.addActionListener(this);
           yb_emoji.addMouseListener(this);
           dizibutonlar();
           ekran.add(cmp);
           ekran.pack();

           
       }
       
       public void mayıntarlasıyükleme(){
           yb_emojiImageIcon = getScaledImage("C:\\fotolar\\gulensurat.png");
           tImageIcon = getScaledImage("C:\\fotolar\\t.png");
           mayinImageIcon = getScaledImage("C:\\fotolar\\mayın.png");
           zararImageIcon = getScaledImage("C:\\fotolar\\loss.png");
           üs_emojiImageIcon = getScaledImage("C:\\fotolar\\cry.png");
           birImageIcon = getScaledImage("C:\\fotolar\\1.png");
           ikiImageIcon = getScaledImage("C:\\fotolar\\2.png");
           üçImageIcon = getScaledImage("C:\\fotolar\\3.png");
           dörtImageIcon = getScaledImage("C:\\fotolat\\4.png");
           beşImageIcon = getScaledImage("C:\\fotolat\\5.png");
          
       }
       
       public JMenuBar Menu(){
           JMenuBar mBar =new JMenuBar();
           JMenu oyun = new JMenu("Oyun");
           
           final JMenuItem mtYeni = new JMenuItem("Yeni");
           final JMenuItem mtKolay = new JMenuItem("Kolay Düzey");
           final JMenuItem mtOrta = new JMenuItem("Orta Düzey");
           final JMenuItem mtZor = new JMenuItem("Zor Düzey");
           final JMenuItem mtUltraZor =new JMenuItem("Ultra Zor Düzey");
           final JMenuItem mtyarıyarıya=new JMenuItem("Yarı Yarıya Şans");
           final JMenuItem mtÇıkış = new JMenuItem("Çıkış");
           
           oyun.add(mtYeni);
           oyun.add(mtKolay);
           oyun.add(mtOrta);
           oyun.add(mtZor);
           oyun.add(mtUltraZor);
           oyun.add(mtyarıyarıya);
           oyun.add(mtÇıkış);
           
          
           ActionListener MenuLstnr = new ActionListener() {
               
               public void actionPerformed(ActionEvent ae){
                   if (mtYeni==ae.getSource()) {
                       btnykslk=10;
                       btngnslk=10;
                       mayınlar=10;
                       reset();
                       
                   }
                   if (mtKolay==ae.getSource()) {
                       btnykslk=12;
                       btngnslk=12;
                       mayınlar=12;
                       reset();
                       
                   }
                   if (mtOrta==ae.getSource()) {
                       btnykslk=15;
                       btngnslk=15;
                       mayınlar=50;
                       reset();
                       
                   }
                   if (mtZor==ae.getSource()) {
                       btnykslk=32;
                       btngnslk=38;
                       mayınlar=90;
                       reset();
                       
                       
                   }
                   if (mtUltraZor==ae.getSource()) {
                       btnykslk=90;
                       btngnslk=90;
                       mayınlar=1000;
                       reset();
                       
                   }
                   if (mtyarıyarıya==ae.getSource()) {
                       btnykslk=50;
                       btngnslk=50;
                       mayınlar=1250;
                       reset();
                              
                       
                   }
                   if (mtÇıkış==ae.getSource()) {
                       if (ekran!= null) {
                            ekran.dispose();
                       
                   }
                       System.exit(0);
                       
                   }
                   
                   
               }
           };
           mtYeni.addActionListener(MenuLstnr);
           mtKolay.addActionListener(MenuLstnr);
           mtOrta.addActionListener(MenuLstnr);
           mtZor.addActionListener(MenuLstnr);
           mtUltraZor.addActionListener(MenuLstnr);
           mtÇıkış.addActionListener(MenuLstnr);
           mtyarıyarıya.addActionListener(MenuLstnr);
           mBar.add(oyun);
           return mBar;
           
           
       }
       private int btnykslk =10;
       private int btngnslk=10;
       private int mayınlar=8;
       
       int mayınDizi[][];
       
       JButton button [][];
       JPanel mayınpan=null;
       
       public void dizibutonlar(){
           mayınDizi=new int[btngnslk][btnykslk];
           button=new JButton[btngnslk][btnykslk];
           boolean başla =true;
           if (mayınpan!=null) {
                cmp.remove(mayınpan);
                mayınpan = null;
                başla=false;
           }
               
           
           mayınpan=new JPanel();
           mayınpan.setLayout(new GridLayout(btngnslk,btnykslk));
           for(int i=0; i<btngnslk; i++){
               for(int j=0;j<btnykslk;j++){
                   mayınDizi[i][j]=0;
                   button[i][j]=new JButton("");
                   button[i][j].addActionListener(this);
                   button[i][j].addMouseListener(this);
                   button[i][j].setPreferredSize(new Dimension(32,32));
                   button[i][j].setBackground(Color.PINK);
                   mayınpan.add(button[i][j]);
                           
               }
           }
           mayınpan.setVisible(true);
           cmp.add(mayınpan,BorderLayout.CENTER);
           if (başla) {
               mayınFormat(button);
              
           }
           ekran.pack();
       }
       public void reset(){
           yb_emoji.setIcon(yb_emojiImageIcon);
           dizibutonlar();
           for (int i = 0; i < btngnslk; i++) {
               for (int j = 0; j < btnykslk; j++) {
                    mayınDizi[i][j]=0;
                    button[i][j].addActionListener(this);
                    button[i][j].addMouseListener(this);
                    button[i][j].setText("");
                    button[i][j].setBackground(Color.PINK);
                   
               }
               
           }
           mayınFormat(button);
           System.out.println("");
           System.out.println("");
       }
       public void mayınFormat(JButton button[][]){
           int mayın[] = getRndmNos(btngnslk,btnykslk,mayınlar);
           int count=1;
           for (int i = 0; i < btngnslk; i++) {
                     for (int j = 0; j < btnykslk; j++)
 
                     {
 
                           for (int k = 0; k < mayın.length && mayın[k] != 0; k++) {
                                  if (count == mayın[k]) {
                                         mayınDizi[i][j] = 9;}
                           }
                           count++;
                     }
              }
           int kutusayısı=0;
           for (int i = 0; i < btngnslk; i++) {
               for (int j = 0; j < btnykslk; j++) {
                   kutusayısı=0;
                   if (mayınDizi[i][j] !=9) {
                       if (i > 0 && j>0 ) {
                           if (mayınDizi[i-1][j-1]==9) {
                               kutusayısı++;
                               
                           }
                             if (i > 0) {
                                         if (mayınDizi[i - 1][j] == 9)
                                                kutusayısı++;
                                  }
 
                                  if (i > 0 && j < btnykslk - 1) {
                                         if (mayınDizi[i - 1][j + 1] == 9)
                                               kutusayısı++;
                                  }
 
                                  if (i < btngnslk - 1 && j > 0) {
                                         if (mayınDizi[i + 1][j - 1] == 9)
                                                kutusayısı++;
                                  }
                                  if (i < btngnslk - 1) {
                                         if (mayınDizi[i + 1][j] == 9)
                                                kutusayısı++;
                                  }
 
                                  if (i < btngnslk - 1 && j < btnykslk - 1) {
                                         if (mayınDizi[i + 1][j + 1] == 9)
                                                kutusayısı++;
                                  }
 
                                  if (j > 0) {
                                         if (mayınDizi[i][j - 1] == 9)
                                                kutusayısı++;
                                  }
                                  if (j < btnykslk - 1) {
                                         if (mayınDizi[i][j + 1] == 9)
                                                kutusayısı++;
                                  }
                                  mayınDizi[i][j] = kutusayısı;
                           }
                           
                           
                          }
                       }
               
                      
                   }
           for (int i = 0; i < btngnslk; i++) {
                               for (int j = 0; j < btnykslk; j++) {
                                   System.out.println(" "+mayınDizi[i][j]);
                                   
                                   
                               }
                               System.out.println("");
               
               }
           
            
               
        }
       public int[] getRndmNos(int btngnslk, int btnykslk, int mayınlar) {
              Random rand = new Random();
              int rndmayınlar[] = new int[btngnslk * btnykslk];
              boolean in = false;
              int count = 0;
              while (count < mayınlar) {
                     int rndno = (int) ((btngnslk * btnykslk) * (rand.nextDouble())) + 1;
                     in = false;
                     for (int i = 0; i < count; i++) {
                           if (rndmayınlar[i] == rndno) {
                                  in = true;
                                  break;
                           }
                     }
                     if (!in) {
                           rndmayınlar[count++] = rndno;
                     }
              }
              return rndmayınlar;
       }
       public void actionPerformed(ActionEvent ae) {
 
              if (ae.getSource() == yb_emoji) {
                     reset();
              } else {
                     for (int i = 0; i < btngnslk; i++)
                           for (int j = 0; j < btnykslk; j++) {
                                  if (button[i][j] == ae.getSource()) {
                                         if (mayınDizi[i][j] == 9) {
                                                for (int k = 0; k < btngnslk; k++) {
                                                       for (int l = 0; l < btnykslk; l++) {
 
                                                              if (mayınDizi[k][l] == 9) {
                                                                 
                                                                     button[k][l].setIcon(mayinImageIcon);
                                                              }
 
                                                              button[k][l].removeActionListener(this);
                                                              button[k][l].removeMouseListener(this);
 
                                                       }
                                                }
 
                                         }
                                         if (mayınDizi[i][j] == 1) {
                                             
                                                button[i][j].setIcon(birImageIcon);
                                         }
                                         if (mayınDizi[i][j] == 2) {
                                             
                                                button[i][j].setIcon(ikiImageIcon);
                                         }
                                         if (mayınDizi[i][j] == 3) {
                                             
                                                button[i][j].setIcon(üçImageIcon);
                                         }
                                         if (mayınDizi[i][j] == 4) {
                                             
                                                button[i][j].setIcon(dörtImageIcon);
                                         }
                                         if (mayınDizi[i][j] == 5) {
                                                button[i][j].setIcon(beşImageIcon);
                                         }
                                         if (mayınDizi[i][j] == 0) {
                                                bosbul(i, j);
                                         }
                                  }
                           }
              }
       }
       
       
       public void bosbul(int boxX, int boxY) {
              int arrX[] = new int[(btngnslk) * (btnykslk)];
              int arrY[] = new int[(btngnslk) * (btnykslk)];
              int cntEmpty = 0;
              for (int i = 0; i < ((btngnslk) * (btnykslk)); i++) {
                     arrX[i] = -1;
                     arrY[i] = -1;
              }
              arrX[cntEmpty] = boxX;
              arrY[cntEmpty] = boxY;
              cntEmpty++;
 
              for (int i = 0; i < cntEmpty; i++) {
                     if (arrX[i] > 0) {
                           int xxX = arrX[i] - 1;
                           int yyY = arrY[i];
                           if (mayınDizi[xxX][yyY] == 0) {
                                  if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                                         arrX[cntEmpty] = xxX;
                                         arrY[cntEmpty] = yyY;
                                         cntEmpty++;
                                  }
                           }
                     }
 
                     if (arrX[i] < (btngnslk - 1)) {
                           int xxX = arrX[i] + 1;
                           int yyY = arrY[i];
                           if (mayınDizi[xxX][yyY] == 0) {
                                  if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                                         arrX[cntEmpty] = xxX;
                                         arrY[cntEmpty] = yyY;
                                         cntEmpty++;
                                  }
                           }
                     }
 
                     if (arrY[i] > 0) {
                           int xxX = arrX[i];
                           int yyY = arrY[i] - 1;
                           if (mayınDizi[xxX][yyY] == 0) {
                                  if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                                         arrX[cntEmpty] = xxX;
                                         arrY[cntEmpty] = yyY;
                                         cntEmpty++;
                                  }
                           }
                     }
 
                     if (arrY[i] < (btnykslk - 1)) {
                           int xxX = arrX[i];
                           int yyY = arrY[i] + 1;
                           if (mayınDizi[xxX][yyY] == 0) {
                                  if (!findIn(arrX, arrY, cntEmpty, xxX, yyY)) {
                                         arrX[cntEmpty] = xxX;
                                         arrY[cntEmpty] = yyY;
                                         cntEmpty++;
                                  }
                           }
                     }
              }
 
              for (int k = 0; k < cntEmpty; k++) {
                     button[arrX[k]][arrY[k]].setBackground(new Color(200, 200, 250));
              }
 
       }
       
 public boolean findIn(int[] arrX, int[] arrY, int cntEmpty, int xxX, int yyY) {
              int j = 0;
              for (j = 0; j < cntEmpty; j++) {
                     if ((arrX[j] == (xxX)) && (arrY[j] == (yyY))) {
                           return true;
                     }
              }
              return false;
       }
 
public void mouseS(MouseEvent arg0) {
              
       }
 
 public void mouseP(MouseEvent me) {
           Icon üs_emojiImageIcon = null;
              for (int i = 0; i < btngnslk; i++)
                     for (int j = 0; j < btnykslk; j++) {
                           if (button[i][j] == me.getSource()) {
                                  yb_emoji.setIcon(üs_emojiImageIcon);
                           }
                     }
 
              if (me.getSource() == yb_emoji) {
                     yb_emoji.setIcon(üs_emojiImageIcon);
              }
       }
 public void mouseB(MouseEvent me) {
              
              if (me.getSource() == yb_emoji) {
                     yb_emoji.setIcon(yb_emojiImageIcon);
              }
              for (int i = 0; i < btngnslk; i++)
                     for (int j = 0; j < btnykslk; j++) {
                           if (button[i][j] == me.getSource()) {
                                  if (mayınDizi[i][j] == 9) {
                                      
                                         yb_emoji.setIcon(zararImageIcon);
                                  } else {
                                         yb_emoji.setIcon(yb_emojiImageIcon);
                                  }
                           }
 
                     }
                    
       }
       
       public ImageIcon getScaledImage(String imageString) {
          ImageIcon imageIcon = new ImageIcon(imageString);
          Image image = imageIcon.getImage(); 
          Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
          imageIcon = new ImageIcon(newimg);
          return imageIcon;
       }
       
 
       public void mouseEntered(MouseEvent arg0) {
              
 
       }
 
       public void mouseExited(MouseEvent arg0) {
             
 
       }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


       
       
}

       

