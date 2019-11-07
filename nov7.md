# Applet program to draw a line on mouse clicks

```java
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class A extends Applet
{

int x1,y1,x2,y2;
int flag=0;
int point=0;

public void init(){
addMouseListener(new B()); 
}

public void paint(Graphics g){

if(point==2)
{
g.drawLine(x1,y1,x2,y2);
}
}

//init calls start, start-> paint

class B extends MouseAdapter{




public void mouseClicked(MouseEvent e){

   if(flag==0)
{
x1=e.getX();
y1=e.getY();
flag=1;
point=1;
}
else if(flag==1)
{
x2=e.getX();
y2=e.getY();
flag=0;
point=2;
}

repaint();
}
  }
}

/* <applet code="A" width=500 height=500>
</applet>*/


```
