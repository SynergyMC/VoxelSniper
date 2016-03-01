package com.thevoxelbox.voxelsniper.util;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Container class for multiple ID/Datavalue pairs.
 */
public class VoxelList
{

    private List<int[]> valuePairs = new ArrayList<int[]>();

    /**
     * Adds the specified id, data value pair to the VoxelList. A data value of -1 will operate on all data values of that id.
     * 
     * @param i
     */
    public void add(int[] i)
    {
        if (i[1] == -1)
        {
            if (!valuePairs.contains(i))
            {
                for (Iterator<int[]> it = valuePairs.iterator(); it.hasNext(); )
                {
                    int[] in = it.next();
                    if (in[0] == i[0])
                    {
                        it.remove();
                    }
                }
                valuePairs.add(i);
            }
        }
        else
        {
            if (!valuePairs.contains(i))
            {
                valuePairs.add(i);
            }
        }
    }

    /**
     * Removes the specified id, data value pair from the VoxelList.
     * 
     * @param i
     * @return true if this list contained the specified element
     */
    public boolean removeValue(final int[] i)
    {
        if (valuePairs.isEmpty())
        {
            return false;
        }
        else
        {
            boolean ret = false;
            if (i[1] == -1)
            {
                for (Iterator<int[]> it = valuePairs.iterator(); it.hasNext(); )
                {
                    int[] in = it.next();
                    if (in[0] == i[0])
                    {
                        it.remove();
                        ret = true;
                    }
                }
            }
            else
            {
                ret = valuePairs.remove(i);
            }
            return ret;
        }
    }

    /**
     * @param i
     * @return true if this list contains the specified element
     */
    public boolean contains(final int[] i)
    {
        for (int[] in : valuePairs)
        {
            if (in[0] == i[0] && (in[1] == i[1] || in[1] == -1))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears the VoxelList.
     */
    public void clear()
    {
        valuePairs.clear();
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty()
    {
        return valuePairs.isEmpty();
    }

    /**
     * Returns a defensive copy of the List with pairs.
     *
     * @return defensive copy of the List with pairs
     */
    public List<int[]> getList()
    {
        return ImmutableList.copyOf(valuePairs);
    }


}
