


# Queue implementation


```c

#include <stdio.h>
#include <ctype.h>

#define MAX 5


int dequeue(int [],int,int);
int enqueue(int [],int);
void display(int [],int ,int);

int main() {

        int front=-1,rear=-1;
        int choice;
        int queue[MAX];
        char c;

        do{
            printf("1.Enqueue\n2.Deque\n3.Display\n");
            scanf("%d",&choice);

            switch(choice){

                case 1:
                    if(((rear==MAX-1)&&(front==0))|| (rear+1==front)){
                        printf("Queue is full\n");
                    }
                    else{
                        if(front==-1){
                            front=0;
                        }
                        rear=enqueue(queue,rear);
                        printf("Now the value of front is  %d and of rear is %d\n",front,rear);

                    }
                    break;

                case 2:
                    if(rear==-1&&front==-1){
                        printf("Can't remove elements\n");

                    }
                    else {
                        front=dequeue(queue,front,rear);
                        if(front==-1){
                            rear=-1;
                        }
                    }
                    break;

                case 3:
                    if(front==-1 && rear==-1)
                        printf("Can't display\n");

                    else
                        display(queue,front,rear);
                    break;

            }


            printf("Do you want to continue Y/N");
            fflush(stdin);
            scanf("%c",&c);
        }
        while(toupper(c)=='Y');
return 0;
}




int  enqueue(int queue[],int rear){
    int element;
    printf("Enter the element to enqueue\n");
    scanf("%d",&element);
    if(rear==MAX-1){
        rear=0;
        queue[rear]=element;
        return rear;
    }
    rear+=1;
    queue[rear]=element;
    return rear;
}

int dequeue(int queue[],int front,int rear){
    if(front==rear){
        printf("the served element  is %d",queue[front]);
        front=-1;
        return front;
    }
    if(front==MAX-1){
        printf("the served element is %d",queue[front]);
        front=0;
        return front;
    }
    printf("the served element is %d",queue[front]);

    front+=1;
    return front;

}


void display(int queue[],int front,int rear){
    int i,k,j;
    if(rear<front){
        for(i=front;i<MAX-1;i++){
           printf("%d ",queue[i]);
        }
        for (j = 0; j < rear; ++j) {
            printf("%d ",queue[i]);
        }
    }
    else{
        for (k = front; k <=rear; ++k) {
            printf("%d ",queue[k]);
        }
    }

}
```