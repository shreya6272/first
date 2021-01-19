package org.example;

import java.util.Scanner;

public class DynamicStack {

    public class StackNode{
        public int info;
        public StackNode next;
        public StackNode(){
            info=0;
            next=null;
        }
    }
   protected StackNode top=new StackNode();
    public DynamicStack(){
        top=null;
    }
   public void push(int item){
        StackNode newnode= new StackNode();
        newnode.info=item;
        if(top==null){
            newnode.next=null;
            top=newnode;
        }
        else{
            newnode.next=top;
            top=newnode;
        }
       }
   public void pop(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
            StackNode temp=new StackNode();
            temp=top;
            top=top.next;
            System.out.println("Popped item is: "+temp.info);
        }
   }
   public void size(){
        if(top==null){
            System.out.println("Stack is empty");
        }
        else{
            StackNode temp= new StackNode();
            temp=top;
            int count=0;
            while(temp!=null){
                count++;
                temp=temp.next;
            }
            System.out.println("Number of elements in stack is: "+count);
        }
   }

   public void peek(){
       if(top==null){
           System.out.println("Stack is empty");
       }
       else{
           StackNode temp=new StackNode();
           temp=top;
           System.out.println("Element at the top of stack is: "+temp.info);
       }
   }

    public static void main(String[] args) {
        int choice;
        int value;
        Scanner sc = new Scanner(System.in);
        DynamicStack ds = new DynamicStack();
        System.out.println("1:Push");
        System.out.println("2:Pop");
        System.out.println("3:Size");
        System.out.println("4:Peek");
        do{
            System.out.println("Enter your choice");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter data item to be inserted");
                    value=sc.nextInt();
                    ds.push(value);
                    break;
                case 2:
                    ds.pop();
                    break;
                case 3:
                    ds.size();
                    break;
                case 4:
                    ds.peek();
                    break;
                default:
                    System.out.println("Invalid choice please enter correct choice");
            }
        }while (choice<5);
    }

}
