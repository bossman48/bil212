import java.util.Scanner;
import java.io.File;

public class DLLDriver {
	public static void main(String[] args) {

		Sequence deneme = new Sequence();
		try{
		Scanner scan = new Scanner(new File(args[0]));
		deneme.makeArray(scan.nextInt());
		while(scan.hasNextLine()){
		
			String input=scan.next();
			if(input.equals("insert")){
				int a=scan.nextInt();
				String type=scan.next();
				String sequence = scan.next();
				//System.out.println("type: "+type+" seq : "+sequence);
				deneme.insert(a,type,sequence);
			}
			else if(input.equals("display-all")){
				deneme.displayAll();
			}
			else if(input.equals("remove")){
				int a=scan.nextInt();
				deneme.remove(a);
			}
			else if(input.equals("display")){
				int a=scan.nextInt();
				deneme.display(a);
			}
			else if(input.equals("copy")){
				int a=scan.nextInt();
				int b=scan.nextInt();
				deneme.copy(a, b);
			}
			else if(input.equals("clip")){
				int a=scan.nextInt();
				int b= scan.nextInt();
				int c=scan.nextInt();
				deneme.clip(a,b,c);
			}
			else if(input.equals("max-overlap")){
				int a=scan.nextInt();
				int b=scan.nextInt();
				deneme.maxOverlap(a, b);
			}
			else if(input.equals("transcribe")){
				int a=scan.nextInt();
				deneme.transcribe(a);
			}
			else if(input.equals("swap")){
				int a=scan.nextInt();
				int b=scan.nextInt();
				int c=scan.nextInt();
				int d=scan.nextInt();
				deneme.swap(a, b, c, d);
			}
			else {
				System.out.println("This command is not suitable :(");
			}
		}
	}
	catch(Exception e){
		System.out.println(e);
	}

		
	
/*deneme.insert(0, "RNA", "ACGUACCCCGU");
deneme.insert( 2, "DNA", "CGTAGTACATGCCTAG");
deneme.insert (3 ,"RNA" ,"UGCACAGUACCGAUAGCAU");
deneme.insert( 5, "RNA" ,"AGUCGUGUAUGCAU");
deneme.insert (6 ,"RNA", "CGAUAC");
deneme.insert (10, "DNA", "AGTCAGGCCATTGCTG");
deneme.insert (11, "RNA", "UAGCAUCCAGGCAUAC");
deneme.insert (12, "DNA" ,"ATTGCTGGCCATGACCA");
deneme.insert( 13, "RNA", "GUCCAGGAUCAUCCU");
deneme.insert (15 ,"DNA", "ACGTAA");
deneme.insert (16, "DNA", "CTGAC");
deneme.insert (17, "RNA", "AUCAUCCUUCAUCCA");
deneme.insert( 19, "DNA", "GCTAAAT");
deneme.insert (18 ,"RNA", "AGTAGT");
deneme.insert( 9, "RNA","");      
deneme.insert( 8, "DNA","");  
deneme.displayAll();
deneme.remove(2);
deneme.remove(6);
deneme.display(10);
deneme.display(6);
deneme.copy(10 ,14);
deneme.clip( 3, 3, 12);
deneme.display(3);
deneme.clip(10, 9, 14);
deneme.display(10);
deneme.clip(10, 4, 8);
deneme.displayAll();
System.out.println("\na\n");
deneme.copy(0 ,4);
System.out.println("\na\n");
deneme.copy(1, 2);
System.out.println("\na\n");
deneme.copy(17, 19);
deneme.displayAll();
System.out.println("\na\n");
deneme.maxOverlap(14, 12);
deneme.maxOverlap(13, 17);
deneme.maxOverlap(13, 15);
deneme.transcribe(5);
deneme.display(5);
deneme.transcribe(12);
deneme.display(12);
deneme.swap(0, 5, 13, 0);
deneme.swap(0, 3, 2, 3);
deneme.swap(15, 6, 16, 1);
deneme.displayAll();
*/
	}


}
