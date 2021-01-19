package org.example;

import java.util.Scanner;

public class DynamicQueue {
    class QNode{
        public int info;
        public QNode next;
        public QNode(){
            info=0;
            next=null;
        }
    }

    QNode rear = new QNode();
    QNode front = new QNode();
    public DynamicQueue(){
        rear=null;
        front=null;
    }

    public void enque(int item){
        QNode newnode = new QNode();
        newnode.info=item;
        newnode.next=null;
        if(rear==null){
            rear=front=newnode;
        }
        else{
            rear.next= newnode;
            rear=newnode;
        }
    }

    public void deque(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else if(rear==front){
            System.out.println("Deleted item is: "+front.info);
            rear=front=null;
        }
        else{
            QNode temp= new QNode();
            temp=front;
            front=front.next;
            System.out.println("Deleted item is: "+temp.info);
        }
    }

    public void size(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else{
            QNode temp= new QNode();
            temp=front; int count=0;
            while (temp!=null){
                count++;
                temp=temp.next;
            }
            System.out.println("The number of items in Queue are: "+count);
        }
    }

    public void peek(){
        if(front==null){
            System.out.println("Queue is empty");
        }
        else if(rear==front){
            System.out.println("Item at the head of Queue is: "+front.info);
        }
        else{
            QNode temp= new QNode();
            temp=front;
            System.out.println("Item at the head of Queue is: "+temp.info);
        }
    }

    public static void main(String[] args) {
        int choice;
        int value;
        Scanner sc = new Scanner(System.in);
        DynamicQueue dq = new DynamicQueue();
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
                    dq.enque(value);
                    break;
                case 2:
                    dq.deque();
                    break;
                case 3:
                    dq.size();
                    break;
                case 4:
                    dq.peek();
                    break;
                default:
                    System.out.println("Invalid choice please enter correct choice");
            }
        }while (choice<5);
    }
}
