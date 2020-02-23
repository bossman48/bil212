public class Sequence {
    public DoublyLinkedList<String> doubly = new DoublyLinkedList<>();
    public String type = "" ;
    Sequence[] asd;
    public Sequence(){
    }
    public void show(){
        System.out.println("Name is :"+type);
        System.out.println(doubly.toString());
    }
    public void makeArray(int a){
        asd = new Sequence[a];
        for (int i = 0; i < asd.length; i++){
            asd[i] = new Sequence();
            asd[i].type="";
        }
    }
    public void insert(int i,String name2,String sequence){
        name2=name2.toUpperCase();
        sequence=sequence.toUpperCase();
        if(!name2.equals("RNA") && !name2.equals("DNA")){
            System.out.println("This type is not correct");
        }
        else if(name2.equals("EMPTY")){
            asd[i].type="EMPTY";
        }
        else if(checkSequence(name2,sequence)){
            asd[i].type="";   //sequence error and type is empty
            System.out.println("This sequence is not correct");
        }else if(sequence == null || sequence.equals(""))
             asd[i].type=name2;
        else{
            asd[i].type=name2;
        asd[i].doubly.removeAll();  
        for(int k=0;k<sequence.length();k++){
            asd[i].doubly.addLast(String.valueOf(sequence.charAt(k)));
        }
        }
    }

    public boolean checkSequence(String type,String a){
        if(type.equals("RNA")){
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!='A' && a.charAt(i)!='C' && a.charAt(i)!='G'  && a.charAt(i)!='U' )
                return true;
        }
        return false;
        }   
        else{
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!='A' && a.charAt(i)!='C' && a.charAt(i)!='G' && a.charAt(i)!='T' )
                    return true;
            }
            return false;
        }
    }
    public void remove(int pos){
        asd[pos].type="";
        int size=asd[pos].doubly.size();
        for(int k=0;k<size;k++){
            asd[pos].doubly.removeLast();
        }
        System.gc();
        System.out.println("The "+pos+" index is removed");
    }
    public void displayAll(){
        for(int k=0;k<asd.length;k++){
            if(asd[k].type.equals(""))
                System.out.println(k+".th:"+asd[k].type+" Empty Slot");
            else
                System.out.println(k+".th:"+asd[k].type+" "+asd[k].doubly.toString());
        }
    }
    public void display(int pos){
        if(asd[pos].type.equals(""))
                System.out.println(pos+".th:"+asd[pos].type+" Empty Slot");
            else
                System.out.println(pos+".th:"+asd[pos].type+" "+asd[pos].doubly.toString());
    }
    public void clip(int pos,int start,int end){
        if(start<0 || end>asd[pos].doubly.size() || end<start){
            System.out.println("This is causing error");
        }else {
        String ret=asd[pos].doubly.getElements();
       // System.out.println(ret);
        String newInsert="";
        for(int i=start;i<=end;i++){
            newInsert +=ret.charAt(i);
        }
        //System.out.println(newInsert);
        asd[pos].doubly.removeAll();
        insert(pos, asd[pos].type, newInsert);
    }  
    }
    public void copy(int pos1,int pos2){
        //asd[pos2].doubly.removeAll();
        System.out.println(asd[pos1].doubly.getElements());
        insert(pos2, asd[pos1].type,asd[pos1].doubly.getElements());
    }
    public void swap(int pos1,int i1,int pos2,int i2){
        if(!asd[pos1].type.equals(asd[pos2].type)){
            System.out.println("Not same type ");
        }
        else if(asd[pos1].doubly.size()<i1 || asd[pos2].doubly.size()<i2 || i1<0 || i2<0){
            System.out.println("Not suitable pos");
        }
        else{
        String pos1String=asd[pos1].doubly.getElements();
        String pos2String=asd[pos2].doubly.getElements();
        String temp1=pos1String.substring(i1);
        String temp2=pos2String.substring(i2);
        pos1String=pos1String.replace(temp1, "");
        pos2String=pos2String.replace(temp2, "");
        pos1String=pos1String.concat(temp2);
        pos2String=pos2String.concat(temp1);
        insert(pos1, asd[pos1].type,pos1String);
        insert(pos2, asd[pos2].type,pos2String);
        System.out.println("swapped from "+pos1+"index"+i1+" to "+pos2+" index "+i2);
        }
    }
    public void maxOverlap(int pos1,int pos2){
        String X =asd[pos1].doubly.getElements() ; 
        String Y = asd[pos2].doubly.getElements(); 
        if(asd[pos1].type.equals(asd[pos2].type))
        System.out.println("Max overlap between "+pos1+" and "+pos2+" "+longestString(Y,X));   
        else
            System.out.println("No Overlap");        
}
        
      
    public void transcribe(int pos){
        String data = "";
        String asd2=asd[pos].doubly.getElements();
        if(!asd[pos].type.equals("DNA")){
            System.out.println("This is not suitable type");
        }
        else{
            for(int i=0;i<asd2.length();i++){
                if(asd2.charAt(i) == 'T')
                    asd2=asd2.substring(0, i)+'U'+asd2.substring(i+1);
            }
           // System.out.println("asd2 : "+asd2);
            for(int i=0;i<asd2.length();i++){
                if(asd2.charAt(i) == 'A'){
                    data+="U";
                }  
                else if(asd2.charAt(i) == 'G')
                    data+="C";
                else if(asd2.charAt(i) == 'C')
                    data+="G";
                else if(asd2.charAt(i) == 'U')
                    data+="A";
                else{
                    System.out.println("This is not suitable for sequence");
                    break;
                }
            }
            String rev="";
            for(int i=data.length()-1;i>=0;i--){
                rev = rev + data.charAt(i);
            }
            //System.out.println(rev);
            insert(pos,"RNA",rev);
        }
    }
    

    public String longestString(String str11, String str22){
        int m = str11.length();
        int n = str22.length();

        int max = 0;

        int[][] dape = new int[m][n];
        int end=-1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(str11.charAt(i) == str22.charAt(j)){

                    // If first row or column
                    if(i==0 || j==0){
                        dape[i][j]=1;
                    }else{
                        // Add 1 to the diagonal value
                        dape[i][j] = dape[i-1][j-1]+1;
                    }

                    if(max < dape[i][j])
                    {
                        max = dape[i][j];
                        end=i;
                    }
                }

            }
        }
        return str11.substring(end-max+1,end+1);
    }

}