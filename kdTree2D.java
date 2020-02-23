import java.util.*;



public class kdTree2D{

    
    Point2D cordinates=new Point2D();
    public kdTree2D root,left,right,parent;
    public int level;
    public String yeri;

     public kdTree2D(){}
     public kdTree2D(kdTree2D parent,kdTree2D left,kdTree2D right,Point2D cordinates,int level,String yerii){
         this.parent=parent;
         this.left=left;
         this.right=right;
         this.cordinates=cordinates;
         this.level=level;
         yeri=yerii;
     }
     public int getLevel(){
         return level;
     }
     public Point2D getPoint(){
        return cordinates;
    }
    public kdTree2D getLeft(){
        return left;
    }
    public kdTree2D getRight(){
        return right;
    }
    public kdTree2D getParent(){
        return parent;
    }
    public kdTree2D getRoot(){
        return root;
    }
    public void addRoot(Point2D point){
         root=new kdTree2D(null, null, null, point, 0,"");
    }
    public void addLeft(kdTree2D kdtree,Point2D point){
         left=new kdTree2D(kdtree, null, null, point, kdtree.getLevel()+1,(kdtree.yeri+0));
    }
    public void addRight(kdTree2D kdtree,Point2D point){
         right=new kdTree2D(kdtree, null, null, point, kdtree.getLevel()+1,(kdtree.yeri+1));
    }
    public Point2D creatPoint2d(int x,int y){
        return new Point2D(x, y);
    }

     public boolean insert(Point2D point){
         if(root==null){
             addRoot(point);
             return true;
         }
         else if(search(point)!=null)
            return false;
         else{
            insertionAux(root,point);
            return true;
         }
     }
     public boolean isExternal(kdTree2D kdtree){
         if(kdtree.getLeft()==null && kdtree.getRight()==null)
            return true;
        else 
            return false;
     }
     public void insertionAux(kdTree2D kdtree,Point2D point){
         //System.out.println("kdTree cordinates: "+kdtree.cordinates.getX()+" "+kdtree.cordinates.getY()+"point cordinates"+point.getX()+" "+point.getY());
         if(kdtree.getLevel()%2==0){
             if(kdtree.getPoint().getX()>=point.getX()){
                 if(kdtree.getLeft()!=null){
                    insertionAux(kdtree.getLeft(),point);
                 }
                 else
                    kdtree.addLeft(kdtree, point);
             }
             else{
                if(kdtree.getRight()!=null)
                    insertionAux(kdtree.getRight(),point);
                else    
                    kdtree.addRight(kdtree, point);
             }   
         }
         else{
            //System.out.println("parent point "+kdtree.getPoint().getY()+" şimdiki point "+point.getY());
            if(kdtree.getPoint().getY()>=point.getY()){
                if(kdtree.getLeft()!=null){
                   insertionAux(kdtree.getLeft(),point);
                }
                else{
                   kdtree.addLeft(kdtree, point);
                }
            }
            else{
               if(kdtree.getRight()!=null)
                   insertionAux(kdtree.getRight(),point);
               else{  
                   kdtree.addRight(kdtree, point);
               }
            }   
         }
     }
     public Point2D search(Point2D point){
         if(searchAux(root,point)==null)
            return null;
        else
         return searchAux(root,point).cordinates;
     }
     public kdTree2D search2(Point2D point){
        return searchAux(root,point);
    }
     public kdTree2D searchAux(kdTree2D kdtree,Point2D point){
         //System.out.println("kdTree cordinates: "+kdtree.cordinates.getX()+" "+kdtree.cordinates.getY()+"point cordinates"+point.getX()+" "+point.getY());
         if(kdtree.cordinates.equals(point)){
             return kdtree;
         }
         else{
             if(kdtree.getLevel()%2==0){
                 if(kdtree.cordinates.getX()<point.getX() && kdtree.getRight()!=null){
                     return searchAux(kdtree.getRight(), point);
                 }
                 else if(kdtree.cordinates.getX()>=point.getX() && kdtree.getLeft()!=null){
                     return searchAux(kdtree.getLeft(), point);
                 }
                 else{
                     return null;
                 }
             }
             else{
                if(kdtree.cordinates.getY()<point.getY() && kdtree.getRight()!=null){
                    return searchAux(kdtree.getRight(), point);
                }
                else if(kdtree.cordinates.getY()>=point.getY() && kdtree.getLeft()!=null){
                    return searchAux(kdtree.getLeft(), point);
                }
                else{
                    return null;
                }
            }
         }
     }
     int k;
     public boolean remove(Point2D point){
         kdTree2D kdtree=search2(point);
         if(kdtree==null){
             System.err.println("Hatalı işlem");
             return false;
         }
         else if(kdtree.getRight()!=null){
             xx=null;
             x=Integer.MAX_VALUE;
             k=1;
             removeAux(kdtree.getRight(),point);
             return true;
         }
         else if(kdtree.getRight()==null && kdtree.getLeft()!=null){
             k=0;
            yy=null;
            y=0;
            removeAux(kdtree.getLeft(),point);
            return true;
        }
         else{
             if(kdtree.getParent().getLeft()!=null && kdtree.getParent().getLeft().equals(kdtree)){
                 kdtree.parent.left=null;
                 kdtree.parent=null;
             }
             else{
                 kdtree.parent.right=null;
                 kdtree.parent=null;
             }
             return true;
         }
     }
     public void removeAux(kdTree2D kdtree,Point2D point){
        // System.out.println("kdtree"+kdtree.cordinates.getX()+" "+kdtree.cordinates.getY());
         Point2D temo;
         if(k==1)
            temo=findMinAux(kdtree, kdtree.getLevel()-1);
         else{
            temo=findMaxAux(kdtree, kdtree.getLevel()-1);
         }
         //System.out.println("temo"+temo.getX()+" "+temo.getY());
         kdTree2D temp=search2(temo);
         //System.out.println("temp"+temp.cordinates.getX()+" "+temp.cordinates.getY());
         kdtree.getParent().cordinates=temo;
         if(temp.getLeft()==null && temp.getRight()!=null){
             temp.cordinates=temp.getRight().cordinates;
             temp.right.parent=null;
             temp.right=null;
         }
         else if(temp.getParent().getLeft()!=null && temp.getParent().getLeft().equals(temp)){
            temp.parent.left=null;
            temp.parent=null;
        }
        else{
            temp.parent.right=null;
            temp.parent=null;
        }
        System.gc();
     }
    public boolean remove2(Point2D point){
        kdTree2D temp2;
        //System.err.println("point: "+point.getX()+" "+point.getY());
         kdTree2D kdtree=search2(point);
         if(isExternal(kdtree)){
             //System.out.println("11");
             if(kdtree.getParent().getLeft()!=null && kdtree.getParent().getLeft().equals(kdtree)){
                 kdtree.getParent().left=null;
                 kdtree.parent=null;
                 System.gc();
             }
             else{
                kdtree.getParent().right=null;
                kdtree.parent=null;
                System.gc();
             }
             return true;
         }
         else if(kdtree==null){
             System.err.println("Hatalı Point2D");
             return false;
         }else{
             System.err.println("kdtree: "+kdtree.cordinates.getX()+" "+kdtree.cordinates.getY());
             Point2D temp=findMinAux(kdtree, kdtree.getLevel());
             if(temp==null){
                 temp=kdtree.cordinates;
                temp2=kdtree;
             }
             else{
             System.err.println("temp: "+temp.getX()+" "+temp.getY());
             //System.out.println("temp: "+temp.x+" "+temp.y);
                temp2=search2(temp);
             }
             kdtree.cordinates=temp;
             System.err.println("temp2: "+temp2.cordinates.getX()+" "+temp2.cordinates.getY());
             //System.err.println("temp2: "+temp2.getParent().getLeft().cordinates.getX()+" "+temp2.cordinates.getY());
             if(temp2.getParent().getLeft()!=null && temp2.getParent().getLeft().equals(temp2)){
                 //System.out.println("1");
                temp2.getParent().left=null;
                temp2.parent=null;
                temp2.cordinates=null;
                System.gc();
             }else{
               // System.out.println("2");
                temp2.getParent().right=null;
                temp2.parent=null;
                temp2.cordinates=null;
                System.gc();
             }
             return true;
         }
     }
    
     public void removeAux(kdTree2D kdtree){
        //System.out.println(kdtree.cordinates.getX()+" "+kdtree.cordinates.getY());
         if(isExternal(kdtree)){
             kdtree.getParent().right=null;
             kdtree.parent=null;
             kdtree.cordinates=null;
             System.gc();
         }
         else{
             if(kdtree.getRight()!=null){
            kdtree.cordinates=kdtree.getRight().cordinates;
            removeAux(kdtree.getRight());
             }
             else if(kdtree.getLeft()!=null){
                kdtree.cordinates=kdtree.getLeft().cordinates;
                removeAux(kdtree.getLeft());
             }
         }
     }
     String str;
     public String toString(){
            str="";
            toStringAux(root);
            return str;
     }
     public void toStringAux(kdTree2D kdtree){
        if(kdtree!=null){
            String asd=" ("+kdtree.cordinates.getX()+","+kdtree.cordinates.getY()+") ";
            str=str.concat(asd);
            if(kdtree.getLeft()!=null)
            toStringAux(kdtree.getLeft());
            if(kdtree.getRight()!=null)
            toStringAux(kdtree.getRight());
        }
     }
     kdTree2D xx;
     int x;
     public Point2D findMin(int d){
         xx=null;
         x=Integer.MAX_VALUE;
         return findMinAux(root,d);
     }

     public Point2D findMinAux(kdTree2D kdtree,int d){
        // System.out.println(kdtree.cordinates.getX()+" "+kdtree.cordinates.getY());
             if(d%2==0){
                if(kdtree.cordinates.getX()<x){
                    xx=kdtree;
                    x=kdtree.cordinates.getX();
                }
                if(kdtree.getLevel()%2==0 && kdtree.getLeft()!=null){
                    findMinAux(kdtree.getLeft(), d);
                }
                else{
                    if(kdtree.getLeft()!=null)
                    findMinAux(kdtree.getLeft(), d);
                    if(kdtree.getRight()!=null)
                    findMinAux(kdtree.getRight(), d);
                }
             }
             else{
                if(kdtree.cordinates.getY()<x){
                    xx=kdtree;
                    x=kdtree.cordinates.getY();
                }
                if(kdtree.getLevel()%2!=0 && kdtree.getLeft()!=null){
                    findMinAux(kdtree.getLeft(), d);
                }
                else{
                    if(kdtree.getLeft()!=null)
                    findMinAux(kdtree.getLeft(), d);
                    if(kdtree.getRight()!=null)
                    findMinAux(kdtree.getRight(), d);
                }
             }
             return xx.cordinates;
     }
     kdTree2D yy;
     int y;
     public Point2D findMax(int d){
         yy=null;
         y=0;
        return findMaxAux(root,d);
    }

    public Point2D findMaxAux(kdTree2D kdtree,int d){
        //System.out.println(kdtree.cordinates.getX()+" "+kdtree.cordinates.getY());

         if(d%2==0){
            if(kdtree.cordinates.getX()>y){
                yy=kdtree;
                y=kdtree.cordinates.getX();
            }
            if(kdtree.getLevel()%2==0 && kdtree.getRight()!=null){
                findMaxAux(kdtree.getRight(), d);
            }
            else{
                if(kdtree.getLeft()!=null)
                findMaxAux(kdtree.getLeft(), d);
                if(kdtree.getRight()!=null)
                findMaxAux(kdtree.getRight(), d);
            }
         }
         else{
            if(kdtree.cordinates.getY()>y){
                yy=kdtree;
                y=kdtree.cordinates.getY();
            }
            if(kdtree.getLevel()%2!=0 && kdtree.getRight()!=null){
                findMaxAux(kdtree.getRight(), d);
            }
            else{
                if(kdtree.getLeft()!=null)
                findMaxAux(kdtree.getLeft(), d);
                if(kdtree.getRight()!=null)
                findMaxAux(kdtree.getRight(), d);
            }
         }
         return yy.cordinates;
    }

    public Point2D nearestNeighbor(Point2D point){
        return nearestNeighborAux(root,point);
    }
    public Point2D nearestNeighborAux(kdTree2D kdtree, Point2D point){
         /*   if(isExternal(kdtree) /*|| (kdtree.getRight()==null && kdtree.getLeft()!=null && isExternal(kdtree.getLeft())) || (kdtree.getRight()!=null && kdtree.getLeft()==null && isExternal(kdtree.getRig()))){
                return kdtree.cordinates;
            }
            else{    */
              //  System.out.println(kdtree.cordinates.getX()+" "+kdtree.cordinates.getY());
            if(kdtree.getLevel()%2==0){
                if(kdtree.cordinates.getX()<point.getX()){
                    if(kdtree.getRight()!=null)
                        return nearestNeighborAux(kdtree.getRight(), point);
                    else 
                        return kdtree.cordinates;
                }
                else{
                    if(kdtree.getLeft()!=null)
                        return nearestNeighborAux(kdtree.getLeft(), point);
                    else 
                        return kdtree.cordinates;
                }
            }
            else{
                if(kdtree.cordinates.getY()<point.getY()){
                    if(kdtree.getRight()!=null)
                        return nearestNeighborAux(kdtree.getRight(), point);
                    else 
                        return kdtree.cordinates;
                 }
                 else{
                    if(kdtree.getLeft()!=null)
                        return nearestNeighborAux(kdtree.getLeft(), point);
                    else 
                        return kdtree.cordinates;
                 }
            }
        
    }
    ArrayList<Point2D> asd=new ArrayList<>();
    Iterable<Point2D> inRectangle(Point2D ll, Point2D ur){
           kdTree2D lowLeft = search2(nearestNeighbor(ll));
           System.out.println(lowLeft.yeri);
           kdTree2D upRight = search2(nearestNeighbor(ur));
           System.out.println(upRight.yeri);
           return inRectangeAux(root,lowLeft.yeri,upRight.yeri,0);
    }
    public ArrayList<Point2D> inRectangeAux(kdTree2D kdtree,String ll,String ur,int i){
        System.err.println("Aux "+ll+" "+ur);
        if(ll.charAt(i) == ur.charAt(i)){
            if(ll.charAt(i)==0){
                asd.add(kdtree.cordinates);
                 inRectangeAux(kdtree.getLeft(),ll,ur,i+1);
            }
            else {   
                asd.add(kdtree.cordinates);
                 inRectangeAux(kdtree.getRight(),ll,ur,i+1);
            }
        }
        else{
            if(ll.charAt(i)==0){
                deneme(kdtree.getLeft(),ll,i+1);
            }
            else{
                deneme(kdtree.getRight(),ll,i+1);
            }
            if(ur.charAt(i)==0){
                deneme(kdtree.getLeft(),ur,i+1);
            }
            else{
                deneme(kdtree.getRight(),ur,i+1);
            }
        }
        return asd;
    }
    public void deneme(kdTree2D kdtree,String str,int i){
        System.out.println("deneme "+ str);
        if(isExternal(kdtree)){
            asd.add(kdtree.cordinates);
        }
        else{
            if(str.charAt(i)==0){
                asd.add(kdtree.cordinates);
                deneme(kdtree.getLeft(),str,i+1);
            }
            else{
                asd.add(kdtree.cordinates);
                deneme(kdtree.getRight(),str,i+1);
            }
        }
    }

}