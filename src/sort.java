import java.util.ArrayList;
/**
 * This is used for sorting arrayLists of integers
 * 
 * @author Amalan Iyengar
 * @version 1.0
 */
public class sort {
	final int SORT_ASCENDING=1;
	final int SORT_DESCENDING=0;
	private boolean isSorted(ArrayList<Integer> list,int method){
		for(int i=1,length=list.size();i<length;i++){
			if(method==SORT_ASCENDING){
				if(list.get(i)<list.get(i-1)){
					return false;
				}
			}else{
				if(list.get(i)>list.get(i-1)){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Implements a simple bubble sort for ArrayLists of integers
	 * @param list		The list of numbers you want to sort
	 * @param method	Whether you want to sort ascending or descending. SORT_ASCENDING or 1 for ascending sort, SORT_DESCENDING or 0 for descending
	 * @return			The sorted ArrayList of integers 
	 */
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> list,int method){
		while(!isSorted(list,method)){
			for(int i=1,length=list.size();i<length;i++){
				if(method==SORT_ASCENDING){
					if(list.get(i)<list.get(i-1)){
						int temp=list.get(i);
						list.set(i,list.get(i-1));
						list.set(i-1,temp);
					}
				}else{
					if(list.get(i)>list.get(i-1)){
						int temp=list.get(i);
						list.set(i,list.get(i-1));
						list.set(i-1,temp);	
					}
				}
			}
		}
		return list;
	}
}
