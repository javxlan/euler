package dome;

public class TrainComposition {
    private TrainNode leftMost;
    private TrainNode rightMost;

    public TrainComposition(){
        leftMost=null;
        rightMost=null;
    }

    public void attachWagonFromLeft(int wagonId) {
        TrainNode tmp=new TrainNode(wagonId);
        if(leftMost!=null){
            //trains in composition
            leftMost.setLeftTrain(tmp);
            tmp.setRightTrain(leftMost);
            leftMost=tmp;
        }else{
            leftMost=tmp;
            rightMost=tmp;
        }
    }

    public void attachWagonFromRight(int wagonId) {
        TrainNode tmp=new TrainNode(wagonId);
        if(rightMost!=null){
            //trains in composition
            rightMost.setRightTrain(tmp);
            tmp.setLeftTrain(rightMost);
            rightMost=tmp;
        }else{
            leftMost=tmp;
            rightMost=tmp;
        }
    }

    public int detachWagonFromLeft() {
        TrainNode tmp;
        if(leftMost!=null){
            tmp=leftMost;
            leftMost=leftMost.rightTrain;
            int tmpValue=tmp.value;
            return tmpValue;
        }else{
            return 0;
        }
    }

    public int detachWagonFromRight() {
        TrainNode tmp;
        if(rightMost!=null){
            tmp=rightMost;
            rightMost=rightMost.leftTrain;
            int tmpValue=tmp.value;
            return tmpValue;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
    class TrainNode{
        int value;
        TrainNode leftTrain;
        TrainNode rightTrain;

        public TrainNode(int value){
            this.value=value;
            this.leftTrain=null;
            this.rightTrain=null;
        }
        public void setRightTrain(TrainNode right){
            this.rightTrain=right;
        }
        public void setLeftTrain(TrainNode left){
            this.leftTrain=left;
        }
    }
}
