import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class Delivery {
    //initialise list of nodes which require delivery
    static int[] orderList = {2,5};
    //method to find the optimal route to each required node
    public static List<Graph.Node> findRoute(Graph graph){
        //declare optimal route array
        List<Graph.Node> optimalRoute = new ArrayList<>();
        //initialise current node
        int currentNode = 1;
        //delivery completion indicator set to false
        boolean completed = false;
        //while there are still deliveries to be made
        while(completed == false ) {
            //currentbest reset to high value to be overwritten
            Graph.Node currentBest = new Graph.Node(99,99);
            //trigger for removing current node from delivery list set to false
            boolean targetObserved = false;
            //for each reachable node from the current node
            for(Graph.Node node: graph.adj_list.get(currentNode )) {
                if (targetObserved == true){
                    ArrayUtils.removeElement(orderList,currentNode);
                    if(ArrayUtils.isEmpty(orderList)) {
                        completed = true;
                    }
                    targetObserved = false;
                }
                //if its weight is less than the lowest observed
                if (node.weight < currentBest.weight) {
                    currentBest = node;
                }
                //if the reachable node is a delivery target 
                if (ArrayUtils.contains(orderList, node.value));{
                    currentBest = node;
                    targetObserved = true;
                    break;
                }
            }
            optimalRoute.add(currentBest);
            currentNode = currentBest.value-1;
        }
        return optimalRoute;
    }
}

    


