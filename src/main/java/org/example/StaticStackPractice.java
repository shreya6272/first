package org.example;

import java.util.Scanner;

public class StaticStackPractice {

    class StackStructure{
        final int Size =6;
        public int item[]=new int[Size];
        public int top;
        public StackStructure(){
            top=-1;
        }
        boolean IsFull(){
            return top==Size-1;
        }
        boolean IsEmpty(){
            return top==-1;
        }
    }

    StackStructure s = new StackStructure();

    public void push(int value){
        if(!s.IsFull()){
            s.top++;
            s.item[s.top]=value;
        }
        else
            System.out.println("Stack is full");
    }

    public void pop(){
        if(s.IsEmpty())
            System.out.println("Stack is empty");
        else{
            int x;
            x=s.item[s.top];
            s.top--;
            System.out.println("Popped element is: "+x);
        }
    }

    public void size(){
        if(s.IsEmpty())
            System.out.println("Stack is empty");
        else{
            int count=0;
            for(int i=0;i<s.top;i++){
                count++;
            }
            System.out.println("The number of elements in stack are: "+count);
        }
    }

    public void peek(){
        if(s.IsEmpty())
            System.out.println("Stack is empty");
        else{
            int x = s.item[s.top];
            System.out.println("The element at top is: "+x);
        }
    }

    public static void main(String[] args) {
        int choice;
        int value;
        Scanner sc = new Scanner(System.in);
        StaticStackPractice ss = new StaticStackPractice();
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
                    ss.push(value);
                    break;
                case 2:
                    ss.pop();
                    break;
                case 3:
                    ss.size();
                    break;
                case 4:
                    ss.peek();
                    break;
                default:
                    System.out.println("Invalid choice please enter correct choice");
            }
        }while (choice<5);

    }
}
