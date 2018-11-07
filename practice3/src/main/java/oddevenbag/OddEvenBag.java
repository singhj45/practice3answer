package oddevenbag;
import java.util.HashMap;
import java.util.Map;

public class OddEvenBag {
    private Map<Integer,Integer> intCount ;//= new HashMap<>();
    private int oddNumbers = 0;
    private int evenNumbers = 0;
    private long sum = 0;

    public OddEvenBag() {
        intCount = new HashMap<>();
    }

    public OddEvenBag( int[] n) {
        intCount = new HashMap<>();
        for(int i=0; i<n.length;i++){
            this.add(n[i]);
        }
    }


    public void add(int x) {
        if (intCount.containsKey(x))
            intCount.put(x,intCount.get(x)+1);
        else
            intCount.put(x,1);
        sum += x;
        if(x%2==0)
            oddNumbers++;
        else
            evenNumbers++;
    }

    public Boolean contains(int x) {
        return(intCount.containsKey(x));
    }

    public long sum() {
        return sum;
    }

    public int getCount(int x) {
        if(this.contains(x))
            return intCount.get(x);
        else
            return 0;
    }

    public void increment(){
        addToAll(1);
    }

    public void decrement(){
        addToAll(-1);
    }

    public void remove(int x){
        if(this.contains(x)){
            int count = intCount.get(x);
            if(count==1){
                intCount.remove(x);
            }
            else
                intCount.put(x,intCount.get(x)-1);
        }
    }
    public boolean equals(Object other){
        if(!(other instanceof OddEvenBag))
            return false;
        OddEvenBag oeb = (OddEvenBag)other;
        return (this.evenNumbers == oeb.evenNumbers && this.oddNumbers==oeb.evenNumbers);
    }

    public int hashCode(){
        return this.evenNumbers+this.oddNumbers;
    }
    private void addToAll(int y) {
        Map<Integer,Integer> newMap = new HashMap<>();
        for(int x: intCount.keySet()){
            newMap.put(x+y, intCount.get(x));
        }
        intCount=newMap;
        sum=sum + intCount.size()*y;
        int temp = evenNumbers;
        evenNumbers=oddNumbers;
        oddNumbers=temp;
    }

}
