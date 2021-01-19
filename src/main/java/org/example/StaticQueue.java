package org.example;
import java.util.Scanner;
public class StaticQueue {
    class QueueStructure{
        final int Size=10;
        public int item[]= new int[Size];
        public int rear,front;
        public QueueStructure(){
            rear=-1;
            front=0;
        }
        boolean IsFull(){
            return rear==Size-1;
        }
        boolean IsEmpty(){
            return rear<front;
        }
    }
  QueueStructure q =new QueueStructure();
    public void enque(int el){
        if(!q.IsFull()){
          q.rear++;
          q.item[q.rear]=el;
        }
        else{
            System.out.println("Queue is Full");
        }
    }
  public void deque(){
        if(q.IsEmpty())
            System.out.println("Queue is empty");
        else{
            int el;
            el=q.item[q.front];
            q.front++;
            System.out.println("Deleted element is: "+el);
        }
  }

  public void size(){
        if(q.IsEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            int i, count=0;
            for(i=q.front;i<=q.rear;i++){
                count++;
            }
            System.out.println("Number of elements in Queue are: "+ count);
        }
  }

  public void peek(){
      if(q.IsEmpty())
          System.out.println("Queue is empty");
      else{
          int el;
          el=q.item[q.front];
          System.out.println("Element at the head of Queue is: "+el);
      }
  }

    public static void main(String[] args) {
        int choice;
        int value;
        Scanner sc = new Scanner(System.in);
        StaticQueue sq = new StaticQueue();
        System.out.println("1: Enqueue");
        System.out.println("2: Dequeue");
        System.out.println("3: Size");
        System.out.println("4: Peek");
        do{
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter data item to be inserted");
                    value=sc.nextInt();
                    sq.enque(value);
                    break;
                case 2:
                    sq.deque();
                    break;
                case 3:
                    sq.size();
                    break;
                case 4:
                    sq.peek();
                    break;
                default:
                    System.out.println("Invalid choice please enter correct choice");
            }
        }while (choice<5);
    }
}
