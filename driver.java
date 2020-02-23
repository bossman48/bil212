import java.io.*; 
import java.util.*; 
    public class driver{
        public static void main(String[] args){
            /*kdTree2D kdtree=new kdTree2D();
            kdTree2D.Point2D point=new kdTree2D.Point2D(3, 3);
            kdTree2D.Point2D point2=new kdTree2D.Point2D(2, 9);
            kdTree2D.Point2D point3=new kdTree2D.Point2D(9, 2);
            kdTree2D.Point2D point4=new kdTree2D.Point2D(10, 8);
            kdTree2D.Point2D point5=new kdTree2D.Point2D(10, 10);
            kdTree2D.Point2D point6=new kdTree2D.Point2D(100, 1);
            kdTree2D.Point2D point7=new kdTree2D.Point2D(150, 4);
            kdTree2D.Point2D point8=new kdTree2D.Point2D(4, 4);
            kdtree.insert(point);
            System.out.println(kdtree.root.cordinates.x);
            kdtree.insert(point2);
            kdtree.insert(point3);
            kdtree.insert(point4);
            kdtree.insert(point5);
            kdtree.insert(point7);
            kdtree.insert(point6);
           /* System.out.println(kdtree.getRoot().getLeft().getPoint().getX());
            System.out.println(kdtree.getRoot().getRight().getPoint().getX());
            System.out.println(kdtree.getRoot().getRight().getRight().getPoint().getX());
            System.out.println(kdtree.getRoot().getLeft().getLeft().getPoint().getX());
            System.out.println(kdtree.getRoot().getRight().getLeft().getPoint().getX());
            System.out.println(kdtree.getRoot().getLeft().getRight().getPoint().getX());
            System.out.println(kdtree.search(point7).getX());
            kdtree.remove(point);
            System.out.println(kdtree.root.cordinates.getX()+" "+kdtree.root.cordinates.getY());
            System.out.println(kdtree.root.getRight().cordinates.getX()+" "+kdtree.root.getRight().cordinates.getY());
            //System.out.println(kdtree.root.getRight().getRight().getPoint().getX());
            System.out.println();
            kdtree.toString();
            System.out.println(kdtree.findMin(1).getX());
            System.out.println(kdtree.findMax(2).getY());*/
            kdTree2D tree = new kdTree2D();
            //kdTree2D<Point2D> tree = new kdTree2D<>();
        //Creating points
        Point2D point1 = new Point2D(10, 20);
        Point2D point2 = new Point2D(30, 40);
        Point2D point3 = new Point2D(5, 5);
        Point2D point4 = new Point2D(20, 15);
        Point2D point5 = new Point2D(40, 50);
        Point2D point6 = new Point2D(7, 10);
        Point2D point7 = new Point2D(8, 8);

        //Insertion
        tree.insert(point1); // root
        tree.insert(point2); // root's right child
        tree.insert(point3); // root's left child
        tree.insert(point4); // point2's left child
        tree.insert(point5); // point2's right child
        tree.insert(point6); // point1's right child
        tree.insert(point7); // point6's right child
        System.out.println();
        System.out.println(tree.root.getLeft().cordinates.getX());
        System.out.println(tree.root.getLeft().getRight().cordinates.getX());
        System.out.println(tree.root.getLeft().getRight().getRight().cordinates.getX());
        System.out.println(tree.root.getRight().cordinates.getX());
        System.out.println(tree.root.getRight().getRight().cordinates.getX());
        System.out.println(tree.root.getRight().getLeft().cordinates.getX());
        //System.out.println(tree.root.getLeft().getRight().getRight());
        System.out.println();

        //Search
        System.out.println(tree.search(point1)); // returns point1
        System.out.println(tree.search(point3)); // returns point3
        System.out.println();
            System.out.println("osman");
            tree.toString();
            System.out.println();
        Point2D point8 = new Point2D(80, 80);
        System.out.println(tree.search(point8)); // returns null

        //Find min for x
        Point2D minX = tree.findMin(0);
        System.out.println(minX.x + " " + minX.y); // 5 5
            System.out.println("ilk min");
        //Find min for y
        Point2D minY = tree.findMin(1);
        System.out.println(minY.x + " " + minY.y); // 5 5
        System.out.println("ikinci min");
        //Find max for x
        Point2D maxX = tree.findMax(0);
        System.out.println(maxX.x + " " + maxX.y); // 40 50
        System.out.println("ilk max");
        //Find max for y
        Point2D maxY = tree.findMax(1);
        System.out.println(maxY.x + " " + maxY.y); // 40 50
        System.out.println("ikinci max");
        //Iterable collection
        /*Iterator<Point2D> iterator = tree.inRectangle(new Point2D(0, 0), new Point2D(50, 55)).iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next().x + " " + iterator.next().y); // Prints all points
*/
        //Nearest point
        System.out.println(tree.toString());
        Point2D neighbor1 = tree.nearestNeighbor(new Point2D(100, 100));
        System.out.println(neighbor1.x + " " + neighbor1.y); // 40 50
            System.out.println("first neighbour");
        Point2D neighbor2 = tree.nearestNeighbor(new Point2D(10, 10));
        System.out.println(neighbor2.x + " " + neighbor2.y); // 8 8
        System.out.println("second neighbour");
        Point2D neighbor3 = tree.nearestNeighbor(new Point2D(8, 10));
        System.out.println(neighbor3.x + " " + neighbor3.y); // 7 10
        System.out.println(tree.search2(neighbor3).yeri);
        System.out.println("third neighbour");
        //Basic remove and traverse
        //System.out.println(tree.str);
        System.out.println(tree.toString());
        tree.remove(point5);
        System.out.println(tree.toString());
        tree.remove(point7);
        System.out.println(tree.toString()); // with preorder traversal the tree should be (10, 20), (5, 5), (7, 10), (30, 40), (20, 15)
        tree.remove(point6);
        System.out.println(tree.toString()); // with preorder traversal the tree should be (10, 20), (5, 5), (30, 40), (20, 15)
            System.out.println("osman2");
        //Adding back the removed elements but different order
        tree.insert(point7);
        tree.insert(point6); //root's left subtree must be changed
        tree.insert(point5);
        System.out.println(tree.toString());  // with preorder traversal the tree should be (10, 20), (5, 5), (8, 8), (7, 10), (30, 40), (20, 15), (40, 50)
        System.out.println();
        // Remove nodes with child/children and traverse
        tree.remove(point1); //we are going to delete the root and the root has two children
        System.out.println(tree.toString()); // with preorder traversal the tree should be (20, 15), (5, 5), (8, 8), (7, 10), (30, 40), (40, 50)*/
        }
    }