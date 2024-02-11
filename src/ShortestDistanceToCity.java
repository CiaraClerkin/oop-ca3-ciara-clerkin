import java.util.*;

public class ShortestDistanceToCity {
    public static void main(String[] args) {
        String from = "Pendleton";
        PriorityQueue<DistanceTo> pq = new PriorityQueue<DistanceTo>();
        pq.add(new DistanceTo(from, 0));

        Map<String, TreeSet<DistanceTo>> directConnections = new HashMap<String, TreeSet<DistanceTo>>();
        Map<String, Integer> shortestKnownDistance = new HashMap<String, Integer>();

        while (!pq.isEmpty()) {
            DistanceTo smallest = pq.poll();

            if (shortestKnownDistance.containsKey(smallest.getTarget())) {
                shortestKnownDistance.put(smallest.getTarget(), smallest.getDistance());

                TreeSet<DistanceTo> ts = directConnections.get(smallest.getTarget());
                Iterator<DistanceTo> itr = ts.iterator();

                while (itr.hasNext()) {
                    pq.add(new DistanceTo(ts.first().getTarget(), smallest.getDistance() + ts.first().getDistance()));
                }

                /*for (int i = 0; i < directConnections.get(smallest.getTarget()).size(); i++) {
                    TreeSet ts = directConnections.get(smallest.getTarget());
                    pq.add(new DistanceTo(ts., smallest.getDistance() + directConnections.get(smallest.)));
                }*/
            }
        }
    }
}
