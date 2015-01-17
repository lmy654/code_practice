package exercise.algorithm;

import java.util.Stack;

public class ArrangeTest {
	private int[] a;
	private Stack<Integer> list;
	private int sum;
	
	public ArrangeTest(int[] a){
		this.a = a;
		list = new Stack<Integer>();
	}
	
	public static void main(String[] args) {
		ArrangeTest a = new ArrangeTest(new int[]{1, 2, 3, 4});
		a.arrange(0, 2);
		System.out.println(a.getSum());
	}
	
	public void arrange(int m, int n){
		if(n == 1){
			for(int i = m; i < a.length; i++){
				printList(list);
				System.out.println(a[i]);
				setSum(getSum() + 1);
			}

		}
		else{
			for(int i = m; i < a.length; i++){
				list.push(a[m]);
				arrange(m+1, n-1);
				list.pop();
				makeArrayLeftStep(m);
			}
		}
	}
	
	private void makeArrayLeftStep(int from){
		int temp = a[from];
		for(int i = from; i < a.length - 1; i++){
			a[i] = a[i + 1];
		}
		a[a.length - 1] = temp;
	}
	
	private void printList(Stack<Integer> list){
		for(int i : list){
			System.out.print(i + " ");
		}
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
