/**
 * Practiced on 9/30/2013
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise 
 * return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 */

package com.congli.leetcode;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) return 0;
        int size = gas.length, start = 0, next = (start + 1) % size;
        int gas_cummulate = gas[0], cost_current = cost[0];

        while (start != next) {
        	if (gas_cummulate >= cost_current) {
        		gas_cummulate = gas_cummulate - cost_current + gas[next];
        		cost_current = cost[next];
        		next = (next + 1) % size;
        	} else {
        		int previous = (start - 1 + size) % size;
        		gas_cummulate = gas_cummulate - cost[previous] + gas[previous];
        		start = previous;
        	}
        }
        return gas_cummulate < cost_current ? -1 : start;
    }
}
