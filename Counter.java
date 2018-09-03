
/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Charles Hoot 
 * @version 4.0
 */
public class Counter
{
    private int myMin;
    private int myMax;
    private int myValue;
    private boolean hasRolledOver;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter()
    {
        myMin = 0;
        myMax = Integer.MAX_VALUE;
        myValue = myMin;
        hasRolledOver = false;
    }
    
    
    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max)
    {
        if(min >= max)
            throw new CounterInitializationException("minimum value not less than maximum value");
        myMin = min;
        myMax = max;
        myValue = myMin;
        hasRolledOver = false;
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param  otherObject   the object to test against for equality
     * @return     true if the objects are in the same state
     */
    public boolean equals(Object otherObject)
    {
        boolean result = true;
        if (otherObject instanceof Counter)
        {
            Counter otherCounter = (Counter) otherObject;
            result = (myMin == otherCounter.myMin)
                    && (myMax == otherCounter.myMax)
                    && (myValue == otherCounter.myValue)
                    && (hasRolledOver == otherCounter.hasRolledOver);
        }
        return result;
    }
    
    

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        myValue++;
        if(myValue > myMax)
        {
            myValue = myMin;
            hasRolledOver = true;
        }
        else
        {
            hasRolledOver = false;
        }
    }
 
 
     /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        myValue--;
        if(myValue < myMin)
        {
            myValue = myMax;
            hasRolledOver = true;
        }
        else
        {
            hasRolledOver = false;
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return     the current value of the counter
     */
    public int value()
    {
        return myValue;
		
    }
    
    
    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return     true if the counter rolled over
     */
    public boolean rolledOver()
    {
        return hasRolledOver;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return     a descriptive string about the object
     */
    public String toString()
    {
        return "Counter: value=" + myValue
                + " min=" + myMin
                + " max=" + myMax
                + " rolled over=" + hasRolledOver;
    }
 
}
