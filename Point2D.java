public  class Point2D {
        public int x;
        
        public int y;

        Point2D(){}
        Point2D(int xx,int yy){
            x=xx;
            y=yy;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setCordinates(int xx,int yy){
            x=xx;
            y=yy;
        }
    }