package com.jiao.learn.datastructure;

import org.springframework.util.StringUtils;

/**
 * @author 29359
 */
public class Stack {

//    栈是只允许在一端进行插入和删除操作的线性表，操作特性可以明显的概括为后进先出
//    n个不同元素进栈，出栈元素不同排列的个数为C(n:2n)/n+1，即卡特兰数
//    栈是一种操作受限的线性表，类似于线性表，它也有对应的两种存储方式
//    采用顺序存储的栈称为顺序栈；栈空：S.top==-1;栈满：S.top==MaxSize-1；栈长：S.top+1
//    由于顺序栈的入栈操作受数组上界的约束，有可能发生栈上溢
//    利用栈底位置相对不变的特性，可让两个顺序栈共享一个一维数组空间，将两个栈的栈底分别设置在共享空间的两端，两个栈顶向共享空间的中间延伸
//    采用连式存储的栈称为链栈，链栈的优点是便于多个栈共享存储空间和提高其效率，且不存在栈满上溢的情况，通常采用单链表实现

      String [] arrays = null ;

      private static int top = -1 ;

    public Stack(int args) {
        if (!StringUtils.isEmpty(arrays)){
            return;
        }

        if (args <= 0 ){
            //默认给
            arrays = new String[10];
        }else {
            arrays = new String[args];
        }
        return ;
    }

    private void initStack(){
        Stack.top = -1 ;
    }

    private boolean isEmpty(){
        if (Stack.top == -1 ){
            return true;
        }
        return false;
    }

    private boolean push(String e){
        if (Stack.top == arrays.length -1 ) {
            return false;
        }
        arrays[++ Stack.top ] = e;
        return true;
    }

    private String pop(){
        if (Stack.top == -1 ){
        throw new RuntimeException("栈内无元素！！！");
        }
        String x = arrays[Stack.top];
        arrays[Stack.top] = null ;
        Stack.top -- ;
        return x;
    }

    private int size(){
        int count = 0 ;
        for (int i = 0; i < arrays.length; i++) {
            String x = arrays[i];
            if (!StringUtils.isEmpty(x)){
                count ++ ;
            }else {
                return count;
            }
        }
        return count;
    }

    private void showElement(){
        int count = arrays.length > Stack.top ? Stack.top : arrays.length  ;
        for (int i = 0; i <= count ; i++) {
            System.out.println("栈内元素 " + arrays[i] + " 当前元素位置 " + i  + "栈顶指针位置：" + Stack.top );
        }
    }

    private void clear (){
        arrays = new String[10];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(0);
        stack.initStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.size());
        stack.showElement();

        
    }
}
