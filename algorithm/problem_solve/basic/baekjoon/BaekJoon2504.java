package problem_solve.basic.baekjoon;

import java.io.*;

public class BaekJoon2504{

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StackImpl stack = new StackImpl();

        int ans = 0;
        for(int i=0; i < str.length(); i++){
            String s = str.substring(i, i+1);

            if(s.equals("(")){
                stack.add(")");
            } else if(s.equals("[")){
                stack.add("]");
            } else {

                int num = 0;
                while(!stack.isEmpty() && !stack.peek().s.equals(")") && !stack.peek().s.equals("]")){
                    num += Integer.parseInt(stack.pop().s);
                }

                if(stack.isEmpty()){
                    ans = 0;
                    break;
                }
                if(stack.peek().s.equals(s)){
                    stack.pop();
                    int newNum = s.equals(")") ? 2 : 3;
                    if(num == 0){
                        stack.add(String.valueOf(newNum));
                    } else {
                        stack.add(String.valueOf(newNum * num));
                    }
                } else {
                    ans = 0;
                    break;
                }

            }
        }

        while(!stack.isEmpty()){
            if(!stack.peek().s.equals(")") && !stack.peek().s.equals("]")){
                ans += Integer.parseInt(stack.pop().s);
            } else {
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }

    public static boolean isVPS(String c, String target){
        if(c.equals(target)){
            return true;
        }
        return false;
    }

    static class StackImpl{
        int size = 0;
        int lastIndex = -1;
        Node[] arr = new Node[30];


        public void add(String s){
            Node newNode = new Node(s);
            arr[++lastIndex] = newNode;
            size++;
        }

        public Node pop(){
            Node retNode = arr[lastIndex];

            lastIndex--;
            size--;
            return retNode;

        }

        public Node peek(){
            return arr[lastIndex];
        }

        public boolean isEmpty(){
            return size==0;
        }
    }

    static class Node{
        String s;
        public Node(String s){
            this.s = s;
        }
    }
}

/* 다른 풀이
import java.io.*;

class Main {
	static char input[];
	static int index;
	static int stk(int mul) { // 1:start 2:paren 3:bracket
		int base = 0, tmp = -1987654321;
		while(index < input.length) {
			switch(input[index++]) {
			case '(':
				tmp = stk(2);
				if(tmp == 0) return 0;
				break;
			case '[':
				tmp = stk(3);
				if(tmp == 0) return 0;
				break;
			case ')':
				if(mul != 2) return 0;
				else return base==0 ? 2 : base*2;
			case ']':
				if(mul != 3) return 0;
				else return base==0 ? 3 : base*3;
			default:
				break;
			}
			base += tmp;
		}
		if(mul!=1) return 0;
		return base;
	}
	public static void main(String aaaaaaaaaa[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		System.out.println(stk(1));
	}
}
 */