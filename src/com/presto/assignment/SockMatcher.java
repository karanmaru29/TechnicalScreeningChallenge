package com.presto.assignment;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SockMatcher {

    Set<Sock> left = new LinkedHashSet<Sock>();
    Set<Sock> right = new LinkedHashSet<Sock>();


    String socksString = "1/blue/right,2/blue/right,3/red/right,4/blue/left,5/purple/left,6/red/left," +
            "7/green/left,8/red/left,9/blue/left";

    public static void main(String args[]) {
        SockMatcher sockMatcher = new SockMatcher();
        sockMatcher.fillList();
        sockMatcher.printMatchingPair();
    }

    /**
     * <p>Fill the left and right list based on a given String</p>
     */
    private void fillList() {
        String sock[] = socksString.split(",");
        for (String s : sock) {
            String sockInfo[] = s.split("/");
            if (sockInfo[2].equalsIgnoreCase("right")) {
                right.add(new Sock(Integer.parseInt(sockInfo[0]), sockInfo[1]));
            } else {
                left.add(new Sock(Integer.parseInt(sockInfo[0]), sockInfo[1]));
            }
        }
    }

    /**
     * <p>It prints the unique pair of socks that matches from left and right set</p>
     */
    private void printMatchingPair() {
        Iterator<Sock> iteratorLeft = left.iterator();
        while (iteratorLeft.hasNext()) {
            Iterator<Sock> iteratorRight = right.iterator();
            Sock left = iteratorLeft.next();
            while (iteratorRight.hasNext()) {
                Sock right = iteratorRight.next();
                if (left.getColor().equals(right.getColor())) {
                    System.out.println(right.getId() + " " + left.getId());
                    iteratorRight.remove();
                    break;
                }
            }
        }
    }
}

