public class stringComparator extends DefaultComparator<String> {
	public int charSum(String s){
		int sum=0;
		for(int i=0;i<s.length();i++)
			sum+=(int)s.charAt(i);
		return sum;
	}
	public int compare(String a,String b){
		if(charSum(a)<charSum(b))
			return -1;
		else if(charSum(a)==charSum(b))
			return 0;
		else
			return 1;
	}
	
	
}