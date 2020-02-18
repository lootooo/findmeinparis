

# Mid point circle generating algorithm.


```c
#include <stdio.h>


#include<conio.h>
#include<graphics.h>

int main(){

    int gd=DETECT,gm;
    int xc,yc,x,p,y,r;
    initgraph(&gd,&gm,"C:\\TC\\BGI");


    printf("Enter the coordinates \n");
    scanf("%d%d",&xc,&yc);

    printf("Enter the radius of the cricle\n");
    scanf("%d",&r);


//    intial  decision paramter p

    p=(5/4)-r;   // incase of Breshnam's  p=3-2*r
    x=0;
    y=r;

    while (x<=y){
        if(p<0){
            x+=1;
            p=p+2*x+3;       //p+4*x+6;
        }
        else{
          x+=1;
          y-=1;
          p=p+2*(x-y)+5;   // p+4*(x-y)+10
        }

        putpixel(xc+x,yc-y,3);
        putpixel(xc+y,yc-x,3);
        putpixel(xc+y,yc+x,3);
        putpixel(xc+x,yc+y,3);
        putpixel(xc-x,yc+y,3);
        putpixel(xc-y,yc+x,3);
        putpixel(xc-y,yc-x,3);
        putpixel(xc-x,yc-y,3);

    }



    getch();
return 0;

}


```