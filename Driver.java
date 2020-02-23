import java.util.*;
import java.io.*;
public class Driver {
	public static void main(String[] args){
		ProbeHashMap<String,String> p=new ProbeHashMap<>(97);
		try{
			Scanner s=new Scanner(new File("dictionary.txt"));
			while(s.hasNextLine()){
				String line=s.nextLine();
				p.put(line,"null");
			}
			System.out.println(p.size());
			System.out.println("Probe Max:"+p.max());
			System.out.println("Probe Avarage:"+p.average());
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			Scanner s=new Scanner(new File("search.txt"));
			int bucketNum=0, bucketTotal=0, bucketMax=0;
			String str="";
			while(s.hasNextLine()){
				int temp=0;
				String results="";
				String line=s.nextLine();
				if(p.get(line)==null){
					results=line+": ";
					for(int i=0;i<line.length()-1;i++){
						str=line.substring(0,i)+line.charAt(i+1)+line.charAt(i)+line.substring(i+2);   // her seye bakar.
						if(p.get(str)!=null)
							if(p.get(str).equals("null"))
								results+=str+", ";
					}
				}
				else{
					System.out.println(line+" is in the list.");
					temp=1;
				}
				if(results.length()>line.length()+2){
					results=results.substring(0,results.length()-2);
					System.out.println(results);
				}
				else
					if(temp==0)
						System.out.println(line+" is not in the list and has not any str words.");
			}
			p.printList();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}