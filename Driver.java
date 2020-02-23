import javax.swing.text.Position;
import java.util.Scanner;
import java.io.File;
public class Driver {
	public static void main(String[] args){
		LinkedBinaryTree<String> bt=new LinkedBinaryTree<String>();
		bt.addRoot("");


		try{
		Scanner scan = new Scanner(new File(args[0]));
		while(scan.hasNextLine()){
			String input=scan.next();
			int i=0;
			if(input.equals("insert")){
				String input2=scan.next();
				System.out.println(input+"  "+input2);
				bt.insertion(input2);
			}
			else if(input.equals("display")){
				System.out.println(input);
				bt.display();
			}
			else if(input.equals("remove")){
				String input2=scan.next();
				System.out.println(input+"  "+input2);
				bt.remove(input2);
			}
			else if(input.equals("search")){
				String input2=scan.next();
				System.out.println(input+"  "+input2);
				bt.search(input2);
			}
			else if(input.equals("display-lengths")){
				System.out.println(input);
				bt.displayLength();
			}
			else 
				System.out.println("This command is not suitable for this application");

		}

	}
	catch(Exception e){
			System.err.println(e);
	}

	/*bt.insertion("ACGT");
	bt.insertion("ACGCA");
	bt.remove("ACGT");
	System.out.println(bt.insert);
	bt.display();*7
		/*bt.insertion("ACGT");
		bt.insertion("ACGCA");	
		/*System.out.println(bt.root.getNodeA().getNodeA().getElement());
		System.out.println(bt.root.getNodeA().getNodeDol().getElement());
		System.out.println(bt.search("TAG"));
		bt.remove("TAG");
		System.out.println(bt.search("TAG"));*/
		/*System.out.println(bt.root.getNodeA().getNodeC().getNodeG().getNodeT().getElement());
		System.out.println(bt.root.getNodeA().getNodeC().getNodeG().getNodeC().getElement());
		bt.display();
		bt.insertion("CACGA");
		bt.insertion("GCACGA");
		bt.insertion("CGACGA");
		bt.display();
		bt.insertion("TCTACGA");
		bt.insertion("GCA");
		bt.display();
		bt.remove("GCACGA");
		bt.remove("GCTCGGA");
		bt.displayLength();
		bt.search("AC");
		bt.search("ACG$");
		bt.search("CGACGA$");
		bt.remove("ACGCA");
		bt.displayLength();*/
		
	}
}